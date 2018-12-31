package db;

import core.model.PitcherGameRecord;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PitcherGameRecordDAO extends AbstractDAO<PitcherGameRecord> {

    public PitcherGameRecordDAO(SessionFactory factory) {
        super(factory);
    }

    public List<PitcherGameRecord> getByPlayer(Long playerId) {
        return list(namedQuery("core.model.PitcherGameRecord.findByPlayer")
                .setParameter("playerId", playerId));
    }

    public List<PitcherGameRecord> findByPlayerAndYear(Long playerId, int year) {
        return list(namedQuery("core.model.PitcherGameRecord.findByPlayerAndYear")
                .setParameter("playerId", playerId)
                .setParameter("year", year));
    }

}
