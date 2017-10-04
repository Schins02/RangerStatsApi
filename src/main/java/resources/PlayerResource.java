package resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.google.common.base.Optional;
import core.Player;
import db.PlayerDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private final PlayerDAO playerDAO;

    public PlayerResource(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<Player> findById(@PathParam("id") LongParam id) {
        return playerDAO.findById(id.get());
    }
}
