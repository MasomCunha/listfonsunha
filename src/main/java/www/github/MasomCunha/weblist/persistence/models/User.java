package www.github.MasomCunha.weblist.persistence.models;

import javax.persistence.*;
import java.util.LinkedList;

@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    @OneToMany (
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "owner",
            fetch = FetchType.EAGER
    )
    private java.util.List<List> lists = new LinkedList<>();

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public java.util.List<List> getLists() {
        return lists;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLists(java.util.List<List> lists) {
        this.lists = lists;
    }

    public void addToLists(List list) {
        lists.add(list);
    }
}

