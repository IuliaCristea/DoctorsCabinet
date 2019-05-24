package DAO;

import java.util.Set;

public interface IDAO<T> {
    T getById(String id);

    Set<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t) ;
}
