package dao.custom.impl;

import dao.custom.CustomerDAO;
import entity.CustomerEntity;
import serverlet.CustomerServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {



    @Override
    public CustomerEntity getCustomer(String idNumber) throws SQLException {
        Connection connection = CustomerServlet.ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE idNumber=?");
        statement.setObject(1,idNumber);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){

            CustomerEntity entity = new CustomerEntity(resultSet.getString(1)
                    , resultSet.getString(2)
                    , resultSet.getString(3)
                    , resultSet.getString(4));
            connection.close();
            return entity;

        }

        connection.close();
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
        boolean b = statement.executeUpdate() > 0;
        connection.close();
        return b;
    }

    @Override
    public ArrayList<CustomerEntity> getAllCustomers() throws SQLException {
        Connection connection = CustomerServlet.ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers");
        ArrayList<CustomerEntity> customers = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            customers.add(new CustomerEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        connection.close();
        return customers;
    }

    @Override
    public String getLastCustomerId() throws SQLException {
        Connection connection = CustomerServlet.ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT idNumber FROM customers ORDER BY idNumber DESC LIMIT 1");
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            String lastID = resultSet.getString(1);
            connection.close();
            return lastID;
        }else{
            connection.close();
            return null;
        }
    }
}
