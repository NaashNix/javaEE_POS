package serverlet;

import bo.BoFactory;
import bo.custom.CustomerBO;
import dto.CustomerDTO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {


    @Resource(name = "java:comp/env/jdbc/pool")
    public static DataSource ds;

    // customerBO
    CustomerBO customerBO = (CustomerBO) BoFactory.getBO(BoFactory.BoTypes.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String option = req.getParameter("option");
        
        switch(option){
            case "SEARCH" : {
                try {
                    CustomerDTO requestedID = customerBO.searchCustomer(req.getParameter("requestedID"));

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customerDTO = new CustomerDTO(
                req.getParameter("customerId"),
                req.getParameter("customerName"),
                req.getParameter("customerTelephone"),
                req.getParameter("customerAddress")
                );
        try {
            boolean b = customerBO.saveCustomer(customerDTO);

            // Response goes here.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
