/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.DAO;

import com.asseco.trening.model.TestKorisnik;
import com.asseco.trening.model.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author LT5
 */
@Stateless
public class UsersDAO extends AbstractDAO<Users>{
    
    public UsersDAO() { //nekoj predefiniran konstruktor
        super(Users.class);
    }
    
        public Users findByUsername(String username) {
          Query query = super.getEntityManager()
                  .createNativeQuery("select * from Users",Users.class);
        
        List<Users> resultList = query.getResultList();

        if(resultList.size() > 0){
            for(Users u : resultList){
                if(u.getUsername().equals(username)){
                    return u;
                }
            }
            //throw new RuntimeException("Two Users with the same username");
        }
        return null; //return resultList.isEmpty() ? null : resultList.get(0);
    }
    
}
