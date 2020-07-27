package www.github.MasomCunha.weblist.persistence.models.jpa;

import javax.persistence.*;

@Entity
public class Item extends AbstractModel {

    private String content;

    public void setList(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }

    @ManyToOne
    private List list;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
