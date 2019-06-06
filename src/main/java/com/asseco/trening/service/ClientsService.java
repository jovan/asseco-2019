/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.service;

import com.asseco.trening.DAO.ClientsDAO;
import com.asseco.trening.model.Clients;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author LT5
 */
@Stateless
public class ClientsService {
    @EJB
    ClientsDAO clientsDAO;
    
    public void persist(Clients client){
        clientsDAO.persist(client);
    }
}
