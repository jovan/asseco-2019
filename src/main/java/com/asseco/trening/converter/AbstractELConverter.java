/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.converter;

import com.asseco.trening.DAO.AbstractDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


public abstract class AbstractELConverter implements Converter {
    @Inject
    AbstractDAO universalDAO;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        Class clazz = this.getClass().getAnnotation(FacesConverter.class).forClass();

        if(clazz==null)
            return null;

        Object returned = universalDAO.customFind(clazz,getKeyValue(value).toString());

        return returned;

    }


    protected Object getKeyValue(String key) {
        return key;
    }
    
   

}
