package www.github.MasomCunha.weblist.persistence.models.jpa;

import www.github.MasomCunha.weblist.persistence.models.jpa.AbstractModel;
import www.github.MasomCunha.weblist.persistence.models.jpa.List;

import javax.persistence.*;
import java.util.LinkedList;

@Entity
public class User extends AbstractModel {


    private String fullName;
    @OneToMany (
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "owner",
            fetch = FetchType.EAGER
    )
    private java.util.List<List> lists = new LinkedList<>();


    public String getFullName() {
        return fullName;
    }

    public java.util.List<List> getLists() {
        return lists;
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

    public void removeList(List list){
        lists.remove(list);
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", lists=" + lists +
                '}';
    }
}

