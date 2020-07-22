package www.github.MasomCunha.weblist.persistence.models;

import javax.persistence.*;
import java.util.LinkedList;

@Entity
public class List {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User owner;
    private String listName;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @OneToMany (
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "list",
            fetch = FetchType.EAGER
    )
    private java.util.List<Item> items = new LinkedList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public java.util.List<Item> getItems() {
        return items;
    }

    public void setItems(java.util.List<Item> items) {
        this.items = items;
    }

    public void addItems(Item item){
        items.add(item);
    }
}
