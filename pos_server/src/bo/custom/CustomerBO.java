package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;

import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    CustomerDTO searchCustomer(String requestedID) throws SQLException;
    
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException;

    public JsonArrayBuilder getAllCustomers() throws SQLException;
    
}
