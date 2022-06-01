package dao.custom;

import dao.SuperDAO;

import java.sql.SQLException;

public interface LoginDAO extends SuperDAO {
    String getUserName(String username) throws SQLException, ClassNotFoundException;

    String getPassword(String username) throws SQLException, ClassNotFoundException;

}
