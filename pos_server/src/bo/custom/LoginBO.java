package bo.custom;

import bo.SuperBO;

public interface LoginBO extends SuperBO {
    boolean getTheUserNameAvailability(String username);

    String getThePasswordById(String username);
}
