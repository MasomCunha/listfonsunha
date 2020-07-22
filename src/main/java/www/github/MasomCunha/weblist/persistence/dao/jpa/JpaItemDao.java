package www.github.MasomCunha.weblist.persistence.dao.jpa;

import www.github.MasomCunha.weblist.persistence.models.Item;

public class JpaItemDao extends GenericJpaDao<Item> {
    public JpaItemDao(Class<Item> modelType) {
        super(modelType);
    }
}
