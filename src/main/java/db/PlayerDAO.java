package db;

import com.google.common.base.Optional;
import core.model.Player;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PlayerDAO extends AbstractDAO<Player> {

    public PlayerDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Player> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public List<Player> findAll() {
        return list(namedQuery("core.model.Player.findAll"));
    }
}
