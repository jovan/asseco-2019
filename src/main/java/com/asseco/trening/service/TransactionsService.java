/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.service;

import com.asseco.trening.DAO.TransactionsDAO;
import com.asseco.trening.model.Transactions;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author j0van
 */
@Stateless
public class TransactionsService {
    
    @EJB
    private TransactionsDAO transactionsDAO;
    
    public List<Transactions> findAll() {
        return transactionsDAO.findAll();

    }
}
