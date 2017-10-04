package core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Created by johnschindler on 9/30/17.
 */

@Entity
@Table(name = "rangerstats_player")
public class Player {

    @Id
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String position;
    private String team;
    private String bat;
    @Column(name = "throw_hand")
    private String throwHand;
    private String height;
    private int age;
    private int weight;



//    @Column(name = "firstName", nullable = false)
//    private String firtsName;

    public long getId() {
        return id;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public String getTeam() {
        return team;
    }

    public String getBat() {
        return bat;
    }

    public String getThrowHand() {
        return throwHand;
    }

    public String getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
