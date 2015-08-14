package com.cabtest.service;

import com.cabtest.model.Login;

public interface LoginService extends GenericPersistenceService<Login, String> {

    boolean validate(String userName, String password);
}
