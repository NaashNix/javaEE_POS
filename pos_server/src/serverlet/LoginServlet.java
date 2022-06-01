package serverlet;

import bo.BoFactory;
import bo.custom.LoginBO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final LoginBO loginBO = (LoginBO) BoFactory.getBO(BoFactory.BoTypes.LOGIN);

    @Resource(name = "java:comp/env/jdbc/pool")
    public static DataSource ds;      // can get the connection via this.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login Servlet POST method invoked!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login Servlet POST method invoked!");
        String userEnteredUsername = req.getParameter("userName");
        String userEnteredPassword = req.getParameter("password");

        System.out.println(userEnteredUsername + " : "+userEnteredPassword);

        PrintWriter writer = resp.getWriter();
        try {
            boolean theUserNameAvailability = loginBO.getTheUserNameAvailability(userEnteredUsername);
            System.out.println("theUserNameAvailability : "+theUserNameAvailability);
            if (theUserNameAvailability){
                boolean loginAccess = loginBO.getThePasswordById(userEnteredUsername, userEnteredPassword);
                if (loginAccess){
                    // here goes the successful login message.
                    System.out.println("Login : true");
                    writer.print("true");
                }else{
                    // Here goes the password wrong message.
                    writer.print("false");
                    System.out.println("Login : false");
                }
            }else{
                // here goes the username wrong message.
                writer.print("false");
                System.out.println("Login : false");
            }


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

}
