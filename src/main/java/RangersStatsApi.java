import db.*;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

//import io.dropwizard.db.
//import io.dropwizard.db.DatabaseConfiguration;
//import io.dropwizard.hibernate.HibernateBundle;

//TODO : log some stuff?
import resources.*;

//TODO: HACK TO MAKE DB WORK FOR HEROKU?

public class RangersStatsApi extends Application<ApiConfig> {

    public static void main(String[] args) throws Exception {
        new RangersStatsApi().run(args);
    }

    private final HibernateBundle<ApiConfig> hibernateBundle =
            new ScanningHibernateBundle<ApiConfig>("core") {
                @Override
                public DataSourceFactory getDataSourceFactory(ApiConfig configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(final Bootstrap<ApiConfig> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final ApiConfig configuration, final Environment environment) {
        final PlayerDAO playerDAO = new PlayerDAO(hibernateBundle.getSessionFactory());
        final HitterSeasonStatsDAO hitterSeasonStatsDAO = new HitterSeasonStatsDAO(hibernateBundle.getSessionFactory());
        final PitcherSeasonStatsDAO pitcherSeasonStatsDAO = new PitcherSeasonStatsDAO(hibernateBundle.getSessionFactory());
        final HitterGameRecordDAO hitterGameRecordDAO = new HitterGameRecordDAO(hibernateBundle.getSessionFactory());
        final PitcherGameRecordDAO pitcherGameRecordDAO = new PitcherGameRecordDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new HitterSeasonStatsResource(hitterSeasonStatsDAO));
        environment.jersey().register(new PitcherSeasonStatsResource(pitcherSeasonStatsDAO));
        environment.jersey().register(new PlayerResource(playerDAO));
        environment.jersey().register(new HitterGameRecordResource(hitterGameRecordDAO));
        environment.jersey().register(new PitcherGameRecordResource(pitcherGameRecordDAO));

    }
}
