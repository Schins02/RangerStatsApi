package core.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rangerstats_pitcher_game_record")

@NamedQueries({
        @NamedQuery(name = "core.model.PitcherGameRecord.findByPlayer",
                query = "select pgr from PitcherGameRecord pgr " +
                        "where pgr.playerId = :playerId order by pgr.gameDate"),

        @NamedQuery(name = "core.model.PitcherGameRecord.findByPlayerAndYear",
                query = "select pgr from PitcherGameRecord pgr " +
                        "where pgr.playerId = :playerId and year(pgr.gameDate) = :year")

})

public class PitcherGameRecord {
    @Id
    private long id;
    @Column(name = "player_id")
    private long playerId;
    @Temporal(TemporalType.DATE)
    @Column(name = "game_date")
    private Date gameDate;
    private int w;
    private int l;
    private double ip;
    private int bf;
    private int er;
    private int r;
    private int h;
    private int bb;
    private int k;
    private int hr;

    public long getId() { return id; }
    public long getPlayerId() { return  playerId; }
    public Date getGameDate() { return gameDate; }
    public int getW() { return w; }
    public int getL() { return l; }
    public double getIp() { return ip; }
    public int getBf() { return bf; }
    public int getEr() { return er; }
    public int getR() { return r; }
    public int getH() { return h; }
    public int getBb() { return bb; }
    public int getK() { return k; }
    public int getHr() { return hr; }
}
