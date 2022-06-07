package dao.custom.impl;

import dao.custom.ItemDAO;
import entity.CustomerEntity;
import entity.ItemEntity;
import serverlet.ItemServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ItemEntity getItem(String itemId) {
        try {
            Connection connection = ItemServlet.ds.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from items where itemId=?");
            statement.setObject(1,itemId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){

                ItemEntity entity = new ItemEntity(resultSet.getString(1)
                        , resultSet.getString(2)
                        , resultSet.getDouble(3)
                        , resultSet.getInt(4)
                        , resultSet.getString(5)
                        , resultSet.getDate(6)
                        , resultSet.getDate(7));
                connection.close();
                return entity;

            }

            connection.close();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
