package bo.custom;

import dto.CustomerDTO;

import java.sql.SQLException;

public interface CustomerBO {
    public CustomerDTO searchCustomer(String requestedID) throws SQLException;
}
