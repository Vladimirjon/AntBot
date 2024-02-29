package DataAccessExamen;

import java.util.List;

public interface tpIDAO<T> {
    public T readBy(Integer id) throws Exception;
    public List<T> readAll() throws Exception;
    public boolean create(T entity) throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
