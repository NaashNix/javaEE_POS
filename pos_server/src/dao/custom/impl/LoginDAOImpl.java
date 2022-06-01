package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.LoginDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public String getUserName(String username) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT user_name FROM login_details WHERE user_name = ?", username);
        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public String getPassword(String username) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT user_name FROM login_details WHERE user_name = ?", username);
        while (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
