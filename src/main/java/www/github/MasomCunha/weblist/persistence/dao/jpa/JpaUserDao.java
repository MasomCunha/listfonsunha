package www.github.MasomCunha.weblist.persistence.dao.jpa;

import www.github.MasomCunha.weblist.persistence.dao.UserDao;
import www.github.MasomCunha.weblist.persistence.models.jpa.User;

public class JpaUserDao extends GenericJpaDao<User> implements UserDao {
    public JpaUserDao(Class<User> modelType) {
        super(modelType);
    }
}
