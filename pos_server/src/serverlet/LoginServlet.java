package serverlet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {



    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource ds;      // can get the connection via this.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login Servlet POST method invoked!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login Servlet POST method invoked!");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        System.out.println("userName : "+ userName + "password : "+password);

        try {
            Connection connection = ds.getConnection();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
