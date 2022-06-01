package dao.custom.impl;

import dao.custom.LoginDAO;
import serverlet.LoginServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public String getUserName(String username) throws SQLException, ClassNotFoundException {

        System.out.println("DAOImpl is running.");

        Connection connection = LoginServlet.ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT user_name FROM login_details WHERE user_name = ?");
        statement.setObject(1,username);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            String receivedUsername = resultSet.getString(1);
            connection.close();
            return receivedUsername;
        }
        connection.close();
        return null;

    }

    @Override
    public String getPassword(String username) throws SQLException, ClassNotFoundException {

        Connection connection = LoginServlet.ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT user_name FROM login_details WHERE user_name = ?");
        statement.setObject(1,username);
        ResultSet resultSet = statement.executeQuery();


        while (resultSet.next()){
            String receivedPassword = resultSet.getString(1);
            connection.close();
            return receivedPassword;
        }
        connection.close();
        return null;
    }
}
