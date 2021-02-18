package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Family {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "family")
    private List<Person> members;

    @SuppressWarnings("unused")
    public Family() {
    }

    public Family(String name) {
        this.name = name;
    }

    public Family(String name, List<Person> members) {
        this.name = name;
        this.members = members;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }
}
