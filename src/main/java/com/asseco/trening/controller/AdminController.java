/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.model.Accountclasses;
import com.asseco.trening.model.Accounttypes;
import com.asseco.trening.model.Transactiontypes;
import com.asseco.trening.model.Users;
import com.asseco.trening.service.AccountClassesService;
import com.asseco.trening.service.AccountTypesService;
import com.asseco.trening.service.TransactionTypesService;
import com.asseco.trening.service.UsersService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author LT5
 */
@Named
@Stateless
public class AdminController {
    Users user;
    Accountclasses accountclasses;
    Accounttypes accounttypes;
    Transactiontypes transactiontypes;
    
    @Inject
    private UsersService usersService;
    @Inject
    private AccountClassesService accountClassesService;
    @Inject
    private AccountTypesService accountTypesService;
    @Inject
    private TransactionTypesService transactionTypesService;
    
    
    public void insertUser(){
        usersService.create(user);
        resetObjects();
    }
    
//    public void insertAccountClasses(){
//        
//    }
//    public void insertAccountTypes(){
//        
//    }
//    public void insertTransactionTypes(){
//        
//    }
    private void resetObjects(){
        user=new Users();
        accountclasses=new Accountclasses();
        accounttypes=new Accounttypes();
        transactiontypes=new Transactiontypes();
    }
}
