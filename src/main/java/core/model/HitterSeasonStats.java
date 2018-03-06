package core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rangerstats_hitter_season_stats")
@NamedQueries({
        @NamedQuery(name = "core.model.HitterSeasonStats.findByPlayerAndYear",
                query = "select  hss from HitterSeasonStats hss where hss.playerId = :playerId and year(hss.seasonYear) = :year")

})
public class HitterSeasonStats {
    @Id
    private long id;
    @Column(name = "player_id")
    private long playerId;
    private int g;
    private int pa;
    private int ab;
    private double avg;
    private int h;
    private int single;
    @Column(name = "double")
    private int doubles;
    private int triple;
    private int hr;
    private int rbi;
    private int bb;
    private int k;
    private int hbp;
    private int sf;
    private double slg;
    private double obp;
    private double ops;
    private double war;
    @Temporal(TemporalType.DATE)
    @Column(name = "season_year")
    private Date seasonYear;

    public long getId() {
        return id;
    }

    public long getplayerId() {
        return playerId;
    }

    public int getG() {
        return g;
    }

    public int getPa() {
        return pa;
    }

    public double getAvg() { return avg; }

    public int getH() { return h; }

    public int getSingle() { return single; }

    public int getDoubles() { return doubles; }

    public int getTriple() { return triple; }

    public int getHr() { return hr; }

    public int getRbi() { return rbi; }

    public int getBb() { return bb; }

    public int getK() { return k; }

    public int getHbp() { return hbp; }

    public int getSf() { return sf; }

    public double getSlg() { return slg; }

    public double getObp() { return obp; }

    public double getOps() { return ops; }

    public double getWar() { return war; }

    public Date getSeasonYear() { return seasonYear; }

}
