package ag04.feeddit.services;

import java.util.List;

public interface CRUDService<T>
{
    List<T> listAll();

    T getById(Integer id);

    T saveOrUpdate(T entity);

    void delete(Integer id);
}
