/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.util;

import com.asseco.trening.model.Users;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author j0van
 */
@ManagedBean
@ViewScoped
@Getter
@Setter
public class UserWizard implements Serializable{
    
    private Users user = new Users();
    
    private boolean skip;
    
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public boolean isSkip() {
        return skip;
    }
    
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}

