package com.cabtest.dao;

import com.cabtest.model.Login;

public class LoginDAOImpl extends GenericDAOImpl<Login, String> implements LoginDAO {
    @Override
    public boolean validate(String userName, String password) {
        Login login = super.findByKey(userName);
        return login != null && login.getPassword().equals(password);
    }
}
