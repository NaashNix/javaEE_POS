package dao.custom.impl;

import dao.custom.CustomerDAO;
import entity.CustomerEntity;
import serverlet.CustomerServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {



    @Override
    public CustomerEntity getCustomer(String idNumber) throws SQLException {
        Connection connection = CustomerServlet.ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE idNumber=?");
        statement.setObject(1,idNumber);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            return new CustomerEntity(resultSet.getString(1)
                    ,resultSet.getString(2)
                    ,resultSet.getString(3)
                    ,resultSet.getString(4));
        }

        return null;
    }

    @Override
    public boolean saveCustomer(CustomerEntity entity) throws SQLException {
        Connection connection = CustomerServlet.ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO customers VALUES(?,?,?,?)");
        statement.setObject(1,entity.getIdNumber());
        statement.setObject(2,entity.getCustomerName());
        statement.setObject(3,entity.getTelephoneNumber());
        statement.setObject(4,entity.getAddress());

        return statement.executeUpdate()>0;
    }
}
