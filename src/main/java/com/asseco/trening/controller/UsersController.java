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
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
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
    
    private Users newUser;
    
    @PostConstruct
    public void init(){
        newUser = new Users();
    }
    
    public void addUser(){
        //TODO: check for properties null and display appropriate message
        
    }
    public void addUserTransaction(){
        
    }
}
