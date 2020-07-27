package www.github.MasomCunha.weblist.services;

import www.github.MasomCunha.weblist.persistence.dao.UserDao;
import www.github.MasomCunha.weblist.persistence.dao.jpa.EntityManagerUtil;
import www.github.MasomCunha.weblist.persistence.dao.jpa.JpaUserDao;
import www.github.MasomCunha.weblist.persistence.models.jpa.List;
import www.github.MasomCunha.weblist.persistence.models.jpa.User;

import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

public class UserServiceImp implements UserService {

    private UserDao userDao = new JpaUserDao(User.class);
    private ListService listService;

    public void setListService(ListService listService) {
        this.listService = listService;
    }

    @Override
    public User createUser(String userName) {
        EntityTransaction et = EntityManagerUtil.getEm().getTransaction();
        et.begin();
        User user = new User();
        user.setFullName(userName);

        try {
            user = userDao.saveOrUpdate(user);
            et.commit();
        }catch (RollbackException e){
            et.rollback();
        }
        return user;
    }

    @Override
    public java.util.List<User> getUsers() {
       return userDao.findAll();
    }

    @Override
    public User getUser(int id) {
        return userDao.findById(id);
    }

    @Override
    public void addList(List list, int userId) {
        userDao.findById(userId).addToLists(list);
    }

    @Override
    public void removeList(int listId) {
        List list = listService.getById(listId);
        userDao.findById(list.getOwner().getId()).removeList(list);
    }

    @Override
    public void deleteUser(int id) {
        EntityTransaction et = EntityManagerUtil.getEm().getTransaction();
        et.begin();
        try {
            userDao.delete(id);
            et.commit();
        }catch (RollbackException e){
            et.rollback();
        }

    }


}
