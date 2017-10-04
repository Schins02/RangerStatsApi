package db;

/**
 * Created by johnschindler on 9/30/17.
 */


import com.google.common.base.Optional;
import core.Player;
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
}
