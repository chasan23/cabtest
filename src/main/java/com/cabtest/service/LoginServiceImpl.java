package com.cabtest.service;

import com.cabtest.ConfigurationBuilder;
import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.LoginDAO;
import com.cabtest.model.Login;
import org.springframework.transaction.annotation.Transactional;

public class LoginServiceImpl extends GenericPersistenceServiceImpl<Login, String> implements LoginService {

    private LoginDAO loginDAO;

    public LoginServiceImpl() {
        super();
    }

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    @SuppressWarnings("unchecked")
    public void setLoginDAO(LoginDAO loginDAO) {
        super.setGenericDAO((GenericDAO) loginDAO);
        this.loginDAO = loginDAO;
    }

    @Override
    @Transactional
    public boolean validate(String userName, String password) {
        Login adminLogin = ConfigurationBuilder.getAdminLoginDetails();
        if (adminLogin.getUserId().equals(userName) && adminLogin.getPassword().equals(password)) {
            return true;
        } else {
            return loginDAO.validate(userName, password);
        }
    }
}
