package resources;

import core.model.HitterGameRecord;
import db.HitterGameRecordDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hitter-game-record")
@Produces(MediaType.APPLICATION_JSON)
public class HitterGameRecordResource {
    private final HitterGameRecordDAO hitterGameRecordDAO;

    public HitterGameRecordResource(HitterGameRecordDAO hitterGameRecordDAO) {
        this.hitterGameRecordDAO = hitterGameRecordDAO;
    }

    @GET
    @Path("/{playerId}")
    @UnitOfWork
    public List<HitterGameRecord> findByPlayer(@PathParam("playerId") LongParam playerId) {
        List<HitterGameRecord> r =  hitterGameRecordDAO.getByPlayer(playerId.get());
        return r;
    }

    @GET
    @Path("/{id}/{year}")
    @UnitOfWork
    public List<HitterGameRecord> findByIdAndYear(@PathParam("id") LongParam id, @PathParam("year") int year) {
        List<HitterGameRecord> r =  hitterGameRecordDAO.getByPlayerAndYear(id.get(), year);
        return r;
    }
}
