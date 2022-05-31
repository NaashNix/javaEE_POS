package bo;

import bo.custom.LoginBO;
import bo.custom.impl.LoginBoImpl;

public class BOFactory {
    private static BoFactory boFactory;

    public BOFactory(BoFactory boFactory) {

    }

    public static BoFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public enum BoTypes{
        LOGIN
    }

    public static SuperBO getBoFactory(BoTypes boTypes) {
        switch (boTypes){
            case LOGIN:
                return new LoginBoImpl();

            default:
                return null;
        }
    }
}
