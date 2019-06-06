/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.model.Accounts;
import com.asseco.trening.model.Clients;
import com.asseco.trening.model.Transactions;
import com.asseco.trening.model.Users;
import com.asseco.trening.service.UsersService;
import com.asseco.trening.util.UserWizard;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author j0van
 */
@Getter
@Setter
@Named("usersController")
@Stateless
public class UsersController {
    
    @Inject
    private UsersService usersService;
    
    private Users newUser;
    private UserWizard userWizard;
    
    @PostConstruct
    public void init(){
        newUser = new Users();
        userWizard = new UserWizard();
    }
    
    public void create(){
        usersService.create(newUser);
        newUser = new Users();
    }
}
