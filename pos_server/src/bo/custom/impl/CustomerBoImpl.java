package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.SuperDAO;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;

import java.sql.SQLException;

public class CustomerBoImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public CustomerDTO searchCustomer(String requestedID) throws SQLException {
        customerDAO.getCustomer(requestedID);

        return null;
    }
}
