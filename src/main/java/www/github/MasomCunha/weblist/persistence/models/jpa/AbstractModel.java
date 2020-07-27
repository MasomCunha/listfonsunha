package www.github.MasomCunha.weblist.persistence.models.jpa;

import www.github.MasomCunha.weblist.persistence.models.Model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * save the last update
     * */
    @Version
    private int version;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
