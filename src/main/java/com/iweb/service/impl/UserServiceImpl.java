package com.iweb.service.impl;

import com.iweb.DAO.Imp.UserDAOImp;
import com.iweb.DAO.UserDAO;
import com.iweb.entity.User;
import com.iweb.service.UserService;


public class UserServiceImpl implements UserService {
    public UserDAO userDAO = new UserDAOImp();

    @Override
    public boolean login(User user) {
        return userDAO.get(user.getName(),user.getPassword())==null?false:true;
    }
}
