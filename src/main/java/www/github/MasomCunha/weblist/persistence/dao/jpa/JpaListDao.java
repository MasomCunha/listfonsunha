package www.github.MasomCunha.weblist.persistence.dao.jpa;

import www.github.MasomCunha.weblist.persistence.dao.ListDao;
import www.github.MasomCunha.weblist.persistence.models.jpa.List;

public class JpaListDao extends GenericJpaDao<List> implements ListDao {
    public JpaListDao(Class<List> modelType) {
        super(modelType);
    }
}
