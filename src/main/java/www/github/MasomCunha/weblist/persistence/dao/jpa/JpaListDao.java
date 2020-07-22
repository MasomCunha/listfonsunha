package www.github.MasomCunha.weblist.persistence.dao.jpa;

import www.github.MasomCunha.weblist.persistence.models.List;

public class JpaListDao extends GenericJpaDao<List> {
    public JpaListDao(Class<List> modelType) {
        super(modelType);
    }
}
