/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.model.Clients;
import com.asseco.trening.service.ClientsService;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author LT5
 */
@Named("clientsController")
public class ClientsController {
    
    @Inject 
    ClientsService clientsService;
    
    @PostConstruct
    public void init(){
//        //BOOTSTRAP LOADING VNESUVANJE NA BANKITE VO CLIENTS TABELATA
//        Clients bank1 = new Clients();
//        bank1.setName("")
//        clientsService.persist(new Clients());
    }
}
