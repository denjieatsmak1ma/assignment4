package repository.interfaces;

import java.util.List;

public interface CrudRepository<T> {
    void create(T entity);
    T read(int id);
    void update(T entity);
    void delete(int id);
    List<T> findAll();
}
