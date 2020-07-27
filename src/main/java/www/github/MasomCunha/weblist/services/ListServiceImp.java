package www.github.MasomCunha.weblist.services;

import www.github.MasomCunha.weblist.persistence.dao.jpa.EntityManagerUtil;
import www.github.MasomCunha.weblist.persistence.dao.jpa.JpaListDao;
import www.github.MasomCunha.weblist.persistence.models.jpa.List;
import www.github.MasomCunha.weblist.persistence.models.jpa.User;

import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

public class ListServiceImp implements ListService {

    JpaListDao ld = new JpaListDao(List.class);
    UserServiceImp userServiceImp;

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public List createList(String listName, int ownerId) {
        EntityTransaction et = EntityManagerUtil.getEm().getTransaction();
        et.begin();
        List list = new List();
        list.setListName(listName);
        list.setOwner(userServiceImp.getUser(ownerId));

        try {
            list = ld.saveOrUpdate(list);
            userServiceImp.addList(list, ownerId);
            et.commit();
        }catch (RollbackException e){
            et.rollback();
        }
        return list;
    }

    @Override
    public List getById(int id) {
        return ld.findById(id);
    }

    @Override
    public void removeList(int id) {
        EntityTransaction et = EntityManagerUtil.getEm().getTransaction();
        et.begin();

        try {
            userServiceImp.removeList(id);
            et.commit();
        }catch (RollbackException e){
            et.rollback();
        }

    }
}
