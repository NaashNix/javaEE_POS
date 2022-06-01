package dao.custom;

import java.sql.SQLException;

public interface LoginDAO {
    String getUserName(String username) throws SQLException, ClassNotFoundException;

    String getPassword(String username) throws SQLException, ClassNotFoundException;

}
