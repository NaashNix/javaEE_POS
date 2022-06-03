package dao.custom;


import dao.SuperDAO;
import entity.CustomerEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends SuperDAO {
    public CustomerEntity getCustomer(String idNumber) throws SQLException;
}
