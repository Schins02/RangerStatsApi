package db;

import com.google.common.base.Optional;
import core.model.HitterSeasonStats;
import core.model.PitcherSeasonStats;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class PitcherSeasonStatsDAO extends AbstractDAO<PitcherSeasonStats> {
    public PitcherSeasonStatsDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<PitcherSeasonStats> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public List<PitcherSeasonStats> findByPlayer(Long playerId) {
        Criteria criteria = criteria().add(Restrictions.eq("playerId", playerId));
        return list(criteria);
    }

    public List<PitcherSeasonStats> findByPlayerAndYear(Long playerId, int year) {
        return list(namedQuery("core.model.PitcherSeasonStats.findByPlayerAndYear")
                .setParameter("id", playerId)
                .setParameter("year", year));
    }
}
