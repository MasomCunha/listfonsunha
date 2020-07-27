package www.github.MasomCunha.weblist.persistence.dao;

import www.github.MasomCunha.weblist.persistence.models.Model;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);

}

