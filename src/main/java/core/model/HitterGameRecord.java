package core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rangerstats_hitter_game_record")
@NamedQueries({
        @NamedQuery(name = "core.model.HitterGameRecord.findByPlayerAndYear",
                query = "select hgr from HitterGameRecord hgr where hgr.playerId = :playerId and year(hgr.gameDate) = :year")

})
public class HitterGameRecord {
    @Id
    private long id;
    @Column(name = "player_id")
    private long playerId;
    @Temporal(TemporalType.DATE)
    @Column(name = "game_date")
    private Date gameDate;
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
    @Column(name = "wrc_plus")
    private int wrcPlus;

    public long getId() { return id; }
    public long getPlayerId() { return playerId; }
    public Date getGameDate() { return gameDate; }
    public int getPa() { return pa; }
    public int getAb() { return  ab; }
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
    public int getWrcPlus() { return wrcPlus; }

}
