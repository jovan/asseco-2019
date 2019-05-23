/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.DAO;

import com.asseco.trening.model.TestKorisnik;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author igor.stojanoski
 */
@Stateless
public class TestKorisniciDAO extends AbstractDAO<TestKorisnik>{ //NASLEDUVA NEMORA DA GI PRAAM METODITE
    
    public TestKorisniciDAO() {
        super(TestKorisnik.class);
    }
    
//    public List<TestKorisnik> getAll(){
//        return super.findAll();
//    }
}
