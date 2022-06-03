package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    CustomerDTO searchCustomer(String requestedID) throws SQLException;
    
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException;
    
}
