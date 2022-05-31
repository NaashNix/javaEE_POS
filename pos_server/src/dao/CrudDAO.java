package dao;

import java.sql.SQLException;

public interface CrudDAO<T,ID> {
    boolean add(T t) throws SQLException, ClassNotFoundException;

    boolean delete(T t) throws SQLException, ClassNotFoundException;
}
