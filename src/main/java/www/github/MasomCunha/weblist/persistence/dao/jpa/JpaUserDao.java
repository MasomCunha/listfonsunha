package www.github.MasomCunha.weblist.persistence.dao.jpa;

import www.github.MasomCunha.weblist.persistence.models.User;

public class JpaUserDao extends GenericJpaDao<User> {
    public JpaUserDao(Class<User> modelType) {
        super(modelType);
    }
}
