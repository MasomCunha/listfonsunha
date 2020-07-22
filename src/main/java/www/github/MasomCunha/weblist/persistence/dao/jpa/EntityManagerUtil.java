package www.github.MasomCunha.weblist.persistence.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManager em;

    public static EntityManager getEm(){
        if (em == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("em");
            em = emf.createEntityManager();
        }
        return em;
    }

}
