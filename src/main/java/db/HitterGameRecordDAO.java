package db;

import core.model.HitterGameRecord;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class HitterGameRecordDAO extends AbstractDAO<HitterGameRecord> {

    public HitterGameRecordDAO(SessionFactory factory) {
        super(factory);
    }

    public List<HitterGameRecord> getByPlayerAndYear(Long playerId, int year) {
        return list(namedQuery("core.model.HitterGameRecord.findByPlayerAndYear")
                .setParameter("playerId", playerId)
                .setParameter("year", year));
    }

}
