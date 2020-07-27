package www.github.MasomCunha.weblist.services;

import www.github.MasomCunha.weblist.persistence.models.jpa.List;
import www.github.MasomCunha.weblist.persistence.models.jpa.User;

public interface UserService {

    User createUser(String userName);

    java.util.List<User> getUsers();

    User getUser(int id);

    void addList(List list, int userId);

    void removeList(int listId);

    void deleteUser(int id);

}
