package com.cabtest.dao;

import com.cabtest.model.Login;

public interface LoginDAO extends GenericDAO<Login, String> {
    boolean validate(String userName, String password);
}
