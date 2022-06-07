package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.CustomerEntity;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public CustomerDTO searchCustomer(String requestedID) throws SQLException {
        CustomerEntity customer = customerDAO.getCustomer(requestedID);
        if (customer != null) {
            return new CustomerDTO(customer.getIdNumber(), customer.getCustomerName(),
                    customer.getTelephoneNumber(), customer.getAddress());
        } else {
            return null;
        }

    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException {
        return customerDAO.saveCustomer(new CustomerEntity(
                customerDTO.getIdNumber(),
                customerDTO.getCustomerName(),
                customerDTO.getTelephoneNumber(),
                customerDTO.getAddress()
        ));
    }

    @Override
    public JsonArrayBuilder getAllCustomers() throws SQLException {
        ArrayList<CustomerEntity> allCustomers = customerDAO.getAllCustomers();
        JsonArrayBuilder customerJsons = Json.createArrayBuilder();
        for (CustomerEntity entity : allCustomers
        ) {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("id", entity.getIdNumber());
            objectBuilder.add("name", entity.getCustomerName());
            objectBuilder.add("telephone", entity.getTelephoneNumber());
            objectBuilder.add("address", entity.getAddress());
            customerJsons.add(objectBuilder.build());
        }
        return customerJsons;
    }

    @Override
    public String getNextCustomerId() throws SQLException {
        String lastCustomerId = customerDAO.getLastCustomerId();
        if (lastCustomerId != null) {
            int lastIDint = (Integer.parseInt(lastCustomerId.substring(2)));
            return String.format("C-%03d", ++lastIDint);
        }else{
            return "C-001";
        }

    }
}
