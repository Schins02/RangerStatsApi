package core.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by johnschindler on 11/5/17.
 */
@Entity
@Table(name = "rangerstats_pitcher_season_stats")
@NamedQueries({
        @NamedQuery(name = "core.model.PitcherSeasonStats.findByPlayerAndYear",
                query = "select pss from PitcherSeasonStats pss where pss.playerId = :playerId and year(pss.seasonYear) = :year")

})
public class PitcherSeasonStats {

    @Id
    private long id;
    @Column(name = "player_id")
    private long playerId;
    private int g;
    private int w;
    private int l;
    private int sv;
    private double ip;
    private double whip;
    @Column(name = "k_per_nine")
    private double kPerNine;
    private int k;
    @Column(name = "bb_per_nine")
    private double bbPerNine;
    private double babip;
    private double era;
    private double fip;
    @Column(name = "x_fip")
    private double xFip;
    private double war;
    @Temporal(TemporalType.DATE)
    @Column(name = "season_year")
    private Date seasonYear;

    public long getId() { return id; }
    public long getPlayerId() { return playerId; }
    public int getG() { return g; }
    public int getW() { return w; }
    public int getL() { return l; }
    public int getSv() { return sv; }
    public double getIp() { return ip; }
    public double getWhip() { return whip; }
    public double getKPerNine() { return kPerNine; }
    public int getK() { return k; }
    public double getBbPerNine() { return bbPerNine; }
    public double getBabip() { return babip; }
    public double getEra() { return era; }
    public double getFip() { return fip; }
    public double getXFip() { return xFip; }
    public double getWar() { return war; }
    public Date getSeasonYear() { return seasonYear; }
}

