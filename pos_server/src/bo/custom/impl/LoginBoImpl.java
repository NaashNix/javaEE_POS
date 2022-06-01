package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.LoginDAO;

import java.sql.SQLException;

public class LoginBoImpl implements LoginBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDAOFactory().getDao(DAOFactory.DAOTypes.LOGIN);

    @Override
    public boolean getTheUserNameAvailability(String username) throws SQLException, ClassNotFoundException {
        if (loginDAO.getUserName(username) == null){
            return false;
        }
        return true;


    }

    @Override
    public boolean getThePasswordById(String username,String userEnteredPassword) throws SQLException, ClassNotFoundException {
        if (loginDAO.getPassword(username) == null){
            return false;
        }
        return true;
    }
}
