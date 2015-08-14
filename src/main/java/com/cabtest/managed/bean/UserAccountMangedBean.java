package com.cabtest.managed.bean;


import com.cabtest.model.Login;
import com.cabtest.service.LoginService;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userAccountMB")
@RequestScoped
public class UserAccountMangedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Logger LOG = Logger.getLogger(UserAccountMangedBean.class);

    @ManagedProperty(value = "#{loginService}")
    LoginService loginService;

    List<Login> accountList;

    String userName;
    String password;

    public void reset() {
        this.setUserName("");
        this.setPassword("");
    }

    public String addAccount() {
        try {
            Login login = new Login(userName, password);

            getLoginService().save(login);

            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add user account.", e);
        }
        return ERROR;
    }

    public String updateAccount() {
        try {
            Login login = new Login();
            login.setUserId(userName);
            login.setPassword(password);
            getLoginService().update(login);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update user account.", e);
        }
        return ERROR;
    }

    public String deleteAccount() {
        try {
            getLoginService().deleteByKey(this.getUserName());
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete account.", e);
        }
        return ERROR;
    }

    public List<Login> getAccountList() {
        accountList = new ArrayList<Login>();
        accountList.addAll(getLoginService().getAll());
        return accountList;
    }

    public void setAccountList(List<Login> accountList) {
        this.accountList = accountList;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


