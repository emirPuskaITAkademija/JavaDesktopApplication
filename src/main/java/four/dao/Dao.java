package four.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * <ol>CRUD template
 * <li>Create</li>
 * <li>Retrieve</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ol>
 * @param <E>
 */
public interface Dao<E>{

    void save(E entity) throws SQLException;

    List<E> getAll() throws SQLException;

    E get(Integer primaryKey) throws SQLException;

    void update(E entity) throws SQLException;

    void delete(E entity) throws SQLException;
}
