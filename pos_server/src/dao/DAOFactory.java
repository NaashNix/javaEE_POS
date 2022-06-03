package dao;

import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.LoginDAOImpl;

public class DAOFactory implements SuperDAO{
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        LOGIN,CUSTOMER
    }

    public SuperDAO getDao(DAOTypes daoTypes){
        switch (daoTypes){
            case LOGIN:
                return new LoginDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            default:
                return null;

        }
    }
}
