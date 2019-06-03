/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.service;

import com.asseco.trening.DAO.AccountsDAO;
import com.asseco.trening.model.Accounts;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author LT5
 */
@Stateless
public class AccountsService {
    
    @EJB
    private AccountsDAO accountsDAO;
    
    public List<Accounts> findAll() {
        return accountsDAO.findAll();

    }
}
