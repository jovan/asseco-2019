/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.converter;

import com.asseco.trening.model.TestKorisnik;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author igor.stojanoski
 */
@FacesConverter(value = "TestKorisniciConverter",forClass = TestKorisnik.class)
public class TestKorisniciConverter extends AbstractELConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}