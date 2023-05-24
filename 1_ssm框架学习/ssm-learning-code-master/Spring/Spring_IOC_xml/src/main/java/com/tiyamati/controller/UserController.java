package com.tiyamati.controller;

import com.tiyamati.service.UserService;

public class UserController {
private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void testSave(){
        userService.save();
    }
}
