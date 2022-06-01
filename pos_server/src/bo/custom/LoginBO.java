package bo.custom;

import bo.SuperBO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    boolean getTheUserNameAvailability(String username) throws SQLException, ClassNotFoundException;

    boolean getThePasswordById(String username,String userEnteredPassword) throws SQLException, ClassNotFoundException;
}
