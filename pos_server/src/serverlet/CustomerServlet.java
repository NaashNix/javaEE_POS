package serverlet;

import bo.BoFactory;
import bo.custom.CustomerBO;
import dto.CustomerDTO;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter writer = resp.getWriter();
        switch(option){
            case "SEARCH" : {
                try {
                    CustomerDTO requestedID = customerBO.searchCustomer(req.getParameter("requestedID"));

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            }

            case "GETALL" : {
                try {
                    JsonArrayBuilder allCustomers = customerBO.getAllCustomers();
                    JsonObjectBuilder response = Json.createObjectBuilder();
                    response.add("status", 200);
                    response.add("message", "Done");
                    response.add("data", allCustomers.build());
                    writer.print(response.build());
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
            System.out.println("B : "+b);
            PrintWriter writer = resp.getWriter();
            writer.print(b);
            // Erase this.
            System.out.println("Customer Saved! ID : "+customerDTO.getIdNumber());
            // Response goes here.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
