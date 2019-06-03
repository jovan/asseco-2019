/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.model.Accounts;
import com.asseco.trening.service.AccountsService;
import java.util.List;
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
    
    @Inject
    private AccountsService accountsService;
    
    public List<Accounts> findAll(){
        return accountsService.findAll();
    }
}
