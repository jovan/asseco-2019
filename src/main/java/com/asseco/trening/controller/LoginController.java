package com.asseco.trening.controller;

import com.asseco.trening.model.Users;
import com.asseco.trening.service.PasswordService;
import com.asseco.trening.service.UsersService;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author LT5
 * 
 * */
@SessionScoped
@Named("loginController")
public class LoginController implements Serializable{
    
    @Inject
    private UsersService usersService;
    
    @Inject
    private PasswordService passwordService;
    
    final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    
    private Users user; //null ne e logiran <=> objet logiran
    
    private String username;
    private String password;
    

 
    public String login() {
        user = usersService.findByUsername(username);
            if(user != null){ //redirect
                if(user.getPassword().equals(password))
                    getSession().setAttribute("user", this.user);
                    return "index.xhtml?faces-redirect=true";
            }
        showMessages("");
        return null;
     }
    
    //logout event, invalidate session
    public String logout() {
            HttpSession session = getSession();
            session.invalidate();
            return "login";
    }

    private static HttpSession getSession() {
            return (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
    }

    private String showMessages(String message){
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Грешен username или password","Грешен username или password"));
        return "";
    }
    private void resetUser(){
        user = null;
        resetText();
    }
    private void resetText(){
        username="";
        password="";
        //clearMessages();
    }
    private void clearMessages(){
        while(FacesContext.getCurrentInstance().getMessages().hasNext()){
            FacesContext.getCurrentInstance().getMessages().remove();
        }
    }
    
    public boolean checkAdmin(){
        return user.getAdmin();
        //TODO: filter and not return null
    }
    
    private String loginAction(){
        return "index.xhtml?faces-redirect=true";
    }
    
    private Boolean checkLogin(){
        return user != null;
    }
    
        public Users getUser() {
        return user;
    }
    
    public boolean isLoggedIn(){
        return user!=null;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getUsername() {
        return username!=null ? username="" : username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password!=null ? password="" : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
