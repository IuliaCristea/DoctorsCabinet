package DAO;

import java.util.List;

public interface IDAO<T> {
    T getById(String id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t) ;
}
