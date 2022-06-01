package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.LoginDAO;

import java.sql.SQLException;

public class LoginBoImpl implements LoginBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDAOFactory().getDao(DAOFactory.DAOTypes.LOGIN);

    @Override
    public boolean getTheUserNameAvailability(String username) throws SQLException, ClassNotFoundException {
        String userName = loginDAO.getUserName(username);
        return userName != null;
    }

    @Override
    public boolean getThePasswordById(String username,String userEnteredPassword) throws SQLException, ClassNotFoundException {
        String password = loginDAO.getPassword(username);
        return userEnteredPassword.equals(password);
    }
}
