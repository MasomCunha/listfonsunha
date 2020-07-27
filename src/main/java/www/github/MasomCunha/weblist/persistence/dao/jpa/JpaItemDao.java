package www.github.MasomCunha.weblist.persistence.dao.jpa;

import www.github.MasomCunha.weblist.persistence.dao.ItemDao;
import www.github.MasomCunha.weblist.persistence.models.jpa.Item;

public class JpaItemDao extends GenericJpaDao<Item> implements ItemDao {
    public JpaItemDao(Class<Item> modelType) {
        super(modelType);
    }
}
