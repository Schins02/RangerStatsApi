import core.Player;
import db.PlayerDAO;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

//import io.dropwizard.db.
//import io.dropwizard.db.DatabaseConfiguration;
//import io.dropwizard.hibernate.HibernateBundle;

//TODO : log some stuff?
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import resources.PlayerResource;

//TODO: HACK TO MAKE DB WORK FOR HEROKU

public class RangersStatsApi extends Application<ApiConfig> {

    public static void main(String[] args) throws Exception {
        new RangersStatsApi().run(args);
    }

    private final HibernateBundle<ApiConfig> hibernateBundle =
            new HibernateBundle<ApiConfig>(Player.class) {
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
//        final StartNewGameResource startNewGameResource = new StartNewGameResource();
//        final ExecuteMoveResource executeMoveResource = new ExecuteMoveResource();
//        final EndGameResource endGameResource = new EndGameResource();
//        environment.jersey().register(startNewGameResource);
//        environment.jersey().register(executeMoveResource);
//        environment.jersey().register(endGameResource);
        final PlayerDAO playerDAO = new PlayerDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new PlayerResource(playerDAO));
    }
}
