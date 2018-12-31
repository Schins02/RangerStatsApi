package resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import core.model.HitterSeasonStats;
import core.model.PitcherSeasonStats;
import db.PitcherSeasonStatsDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import java.util.List;

@Path("/pitcher-season-stats")
@Produces(MediaType.APPLICATION_JSON)
public class PitcherSeasonStatsResource {
    private final PitcherSeasonStatsDAO pitcherSeasonStatsDAO;

    public PitcherSeasonStatsResource(PitcherSeasonStatsDAO pitcherSeasonStatsDAO) {
        this.pitcherSeasonStatsDAO = pitcherSeasonStatsDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<PitcherSeasonStats> findById(@PathParam("id") LongParam id) {
        return pitcherSeasonStatsDAO.findById(id.get());
    }

    @GET
    @Path("/all")
    @UnitOfWork
    public List<PitcherSeasonStats> findAll() {
        return pitcherSeasonStatsDAO.findAll();
    }

}
