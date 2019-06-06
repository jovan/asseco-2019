/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.model.Accounts;
import com.asseco.trening.service.AccountTypesService;
import com.asseco.trening.service.AccountsService;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LT5
 */
@Named("accountsController")
@Stateless
@Getter
@Setter
public class AccountsController {
    
    @Inject private AccountsService accountsService;
    
    @Inject AccountTypesService accountTypesService;
    
    
    
    
//    @PostConstruct
//    public void init(){
//        Accounts acc = new Accounts();
//        acc.setTypeId(accountTypesService.findAll().get(0));
//        acc.setAccountNumber("9999");
//        acc.setBalance(BigDecimal.valueOf(100000.00));
//        acc.setAvailableBalance(BigDecimal.valueOf(100000.00));
//        accountsService.persist(acc);
//    }
    
    public List<Accounts> findAll(){
        return accountsService.findAll();
    }
}
