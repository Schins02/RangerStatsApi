package db;

import com.google.common.base.Optional;
import core.model.HitterSeasonStats;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import java.util.List;

public class HitterSeasonStatsDAO extends AbstractDAO<HitterSeasonStats> {
    public HitterSeasonStatsDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<HitterSeasonStats> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public List<HitterSeasonStats> findByPlayer(Long playerId) {
        Criteria criteria = criteria().add(Restrictions.eq("playerId", playerId));
        return list(criteria);
    }

    public List<HitterSeasonStats> findByPlayerAndYear(Long playerId, int year) {
        return list(namedQuery("core.model.HitterSeasonStats.findByPlayerAndYear")
                .setParameter("playerId", playerId)
                .setParameter("year", year));
    }
}
