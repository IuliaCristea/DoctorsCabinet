package DAO;

import jdk.jshell.spi.ExecutionControl;

import java.io.IOException;
import java.util.List;

public interface IDAO<T> {
    T getById(String id);

    List<T> getAll() throws IOException;

    void save(T t);

    void update(T t);

    void delete(T t) throws ExecutionControl.NotImplementedException;
}
