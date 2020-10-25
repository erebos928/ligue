package match.game.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    private int id;
    private String name;
    private String surname;
    @ManyToOne
    @JoinColumn(name="FK_NATIONALITY")
    private Nationality nationality;
    private int age;
    private double length;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="Player_Team",
            joinColumns = {@JoinColumn(name="FK_PLAYER")},
            inverseJoinColumns = {@JoinColumn(name="FK_TEAM")}
    )
    private Set<Team> teams = new HashSet<Team>();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
