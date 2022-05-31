package bo.custom.impl;

import bo.custom.LoginBO;

public class LoginBoImpl implements LoginBO {
    @Override
    public boolean getTheUserNameAvailability(String username) {
        return false;
    }

    @Override
    public String getThePasswordById(String username) {
        return null;
    }
}
