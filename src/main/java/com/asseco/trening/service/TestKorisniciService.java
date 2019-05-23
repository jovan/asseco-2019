/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.service;

import com.asseco.trening.DAO.TestKorisniciDAO;
import com.asseco.trening.model.TestKorisnik;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author igor.stojanoski
 */
@Stateless
public class TestKorisniciService implements Serializable{
    
    @EJB
    private TestKorisniciDAO testKorisniciDAO;
    
    
    public void kreirajNovKorisnik(TestKorisnik t){
    
        testKorisniciDAO.create(t);
    }
    
    public List<TestKorisnik> findAll(){
        return testKorisniciDAO.findAll();
    } 
   
    
}
