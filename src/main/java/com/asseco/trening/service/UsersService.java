/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.service;

import com.asseco.trening.DAO.TransactionsDAO;
import com.asseco.trening.DAO.UsersDAO;
import com.asseco.trening.model.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author LT5
 */
@Stateless
public class UsersService {
    
    @EJB
    private UsersDAO usersDAO;
    
    @EJB
    private TransactionsDAO transactionsDAO;
    
     public Users findByUsername(String username) {
         return usersDAO.findByUsername(username);
     }
   
     //proverki return Message
    public void create(Users user){
        usersDAO.create(user);
    }
}
