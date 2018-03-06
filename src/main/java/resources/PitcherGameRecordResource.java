package resources;
import core.model.PitcherGameRecord;
import db.PitcherGameRecordDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pitcher-game-record")
@Produces(MediaType.APPLICATION_JSON)
public class PitcherGameRecordResource {
    private final PitcherGameRecordDAO pitcherGameRecordDAO;

    public PitcherGameRecordResource(PitcherGameRecordDAO pitcherGameRecordDAO) {
        this.pitcherGameRecordDAO = pitcherGameRecordDAO;
    }

    @GET
    @Path("/{id}/{year}")
    @UnitOfWork
    public List<PitcherGameRecord> findByIdAndYear(@PathParam("id") LongParam id, @PathParam("year") int year) {
        return pitcherGameRecordDAO.findByPlayerAndYear(id.get(), year);
    }
}
