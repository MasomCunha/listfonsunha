package www.github.MasomCunha.weblist.services;

import www.github.MasomCunha.weblist.persistence.models.jpa.List;

public interface ListService {

    List createList(String listName, int OwnerId);

    List getById(int id);

    void removeList(int id);

}
