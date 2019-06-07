/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.model.Transactions;
import com.asseco.trening.service.TransactionsService;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author LT5
 */
@Named("verificationController")
@Stateless
public class VerificationController {
    
    @Inject
    TransactionsService transactionsService;
    
    private List<Transactions> allTransactions;
    private List<Transactions> filteredTransactions;
    
    @PostConstruct
    public void init(){
        allTransactions = transactionsService.findAll();
    }
    
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public TransactionsService getTransactionsService() {
        return transactionsService;
    }

    public void setTransactionsService(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    public List<Transactions> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(List<Transactions> allTransactions) {
        this.allTransactions = allTransactions;
    }

    public List<Transactions> getFilteredTransactions() {
        return filteredTransactions;
    }

    public void setFilteredTransactions(List<Transactions> filteredTransactions) {
        this.filteredTransactions = filteredTransactions;
    }
    
}
