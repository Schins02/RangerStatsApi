package resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import core.model.HitterSeasonStats;
import core.model.Player;
import db.HitterSeasonStatsDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import java.util.List;

@Path("/hitter-season-stats")
@Produces(MediaType.APPLICATION_JSON)
public class HitterSeasonStatsResource {
    private final HitterSeasonStatsDAO hitterSeasonStatsDAO;

    public HitterSeasonStatsResource(HitterSeasonStatsDAO hitterSeasonStatsDAO) {
        this.hitterSeasonStatsDAO = hitterSeasonStatsDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<HitterSeasonStats> findById(@PathParam("id") LongParam id) {
        return hitterSeasonStatsDAO.findById(id.get());
    }

    @GET
    @Path("/{id}/{year}")
    @UnitOfWork
    public List<HitterSeasonStats> findByIdAndYear(@PathParam("id") LongParam id, @PathParam("year") int year) {
        return hitterSeasonStatsDAO.findByPlayerAndYear(id.get(), year);
    }

    @GET
    @Path("/all")
    @UnitOfWork
    public List<HitterSeasonStats> findAll() {
        return hitterSeasonStatsDAO.findAll();
    }

}
