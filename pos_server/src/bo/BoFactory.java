package bo;

import bo.custom.impl.CustomerBoImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.LoginBoImpl;

public class BoFactory implements SuperBO{
    private static BoFactory boFactory;

    public BoFactory() {
    }

    public static BoFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public enum BoTypes{
        LOGIN,CUSTOMER,ITEM
    }

    public static SuperBO getBO(BoTypes boTypes) {
        switch (boTypes){
            case LOGIN:
                return new LoginBoImpl();
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBOImpl();
            default:
                return null;
        }
    }
}
