/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.DAO;

import com.asseco.trening.model.Accountclasses;
import com.asseco.trening.model.Users;
import javax.ejb.Stateless;

/**
 *
 * @author LT5
 */
@Stateless
public class AccountClassesDAO extends AbstractDAO<Accountclasses>{
    public AccountClassesDAO() {
        super(Accountclasses.class);
    }
}
