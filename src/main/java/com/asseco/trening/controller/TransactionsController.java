/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.service.TransactionsService;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author j0van
 */
@Named("transactionsController")
public class TransactionsController {
    
    @Inject
    private TransactionsService transactionsService;
    
}
