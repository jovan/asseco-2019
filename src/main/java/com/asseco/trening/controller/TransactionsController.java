/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.enumeration.TransactionItnostEnum;
import com.asseco.trening.enumeration.TransactionStatusEnum;
import com.asseco.trening.model.Accounts;
import com.asseco.trening.model.Transactions;
import com.asseco.trening.service.AccountsService;
import com.asseco.trening.service.TransactionsService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author j0van
 */
@Named("transactionsController")
@Stateless
public class TransactionsController {
    
    @Inject
    AccountsService accountsService;
    
    Transactions newTransaction;
    
    private String nazivUplatuvac;
    private String bankaUplatuvac;
    private String danocenEmbg;
    private String cel;
    private String nazivPrimac;
    private String bankaPrimac;
    private String transakciskaPrimac;
    private Double iznos;
    private Integer sifra;
    private TransactionItnostEnum transactionItnostEnum;
    private Date date;
    
    @Inject
    private TransactionsService transactionsService;
    
    @PostConstruct
    private void init(){
        newTransaction = new Transactions();
    }
    
    public List<Transactions> findAll(){
        return transactionsService.findAll();
    }
    
    public void processPP10(){
        checkPP10();
    }
    
    private void checkPP10(){
        Accounts primacAcc = null;
        Accounts bankAcc = null;
        List<Accounts> allAccs = accountsService.findAll();
        for(Accounts a : allAccs){
            if(a.getAccountNumber().equals("999")){
                bankAcc = a;
            }
            else if(a.getAccountNumber().equals(transakciskaPrimac)){
                primacAcc = a;
                break;
            }
        }
        validateAndShowMessage(primacAcc,AccountNotFoundMESSAGE);
        setAttributes();
        proveriSostojba(bankAcc, primacAcc);
        transactionsService.persist(newTransaction);
    }
    private void validateAndShowMessage(Object obj, String message){
        if(obj == null){
            //show message
        }
    }
    private void setAttributes(){
        newTransaction = new Transactions();
        newTransaction.setAmount(BigDecimal.valueOf(iznos));
        newTransaction.setDate(date);
        newTransaction.setItnost(transactionItnostEnum);
        
        newTransaction.setStatus(TransactionStatusEnum.VNESENA);
    }

    private Boolean proveriSostojba(Accounts bankAcc, Accounts clientAcc){
        if(bankAcc.getAvailableBalance().compareTo(clientAcc.getAvailableBalance())  >= 0) return true;
        else return false;
    }
    private String AccountNotFoundMESSAGE = "";
    
        private void reset(){
        newTransaction = new Transactions();
        //TODO: resetiraj site polinja
    }
}
