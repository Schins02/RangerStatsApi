package core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "rangerstats_player")
@NamedQueries({
        @NamedQuery(name = "core.model.Player.findAll",
                query = "select p from Player p")

})

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

    public long getId() {
        return id;
    }
    public String getfirstName() {
        return firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public String getPosition() { return position; }
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
    public int getAge() { return age; }
    public int getWeight() {
        return weight;
    }
}
