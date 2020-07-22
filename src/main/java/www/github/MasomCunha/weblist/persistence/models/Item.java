package www.github.MasomCunha.weblist.persistence.models;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String content;

    public void setList(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }

    @ManyToOne
    private List list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
