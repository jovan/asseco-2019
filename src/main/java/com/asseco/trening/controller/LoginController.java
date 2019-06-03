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
import org.primefaces.context.RequestContext;


/**
 *
 * @author LT5
 * 
 * */
@Getter
@Setter
@SessionScoped
@Named("loginController")
public class LoginController implements Serializable{
    //TODO: Rename ?
    
    @Inject
    private UsersService usersService;
    
    @Inject
    private PasswordService passwordService;
    
    final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    
    private Users user; //null ne e logiran <=> objet logiran
    
    private String username;
    private String password;
    
//    private byte[] salt = new byte[1];
//    
//    @PostConstruct
//    private void assignSalt(){
//        try{
//            salt = getSalt();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }

  
  
    
    //throws NoSuchAlgorithmException
    public String login() {
        //read password from database
        user = usersService.findByUsername(username); 
        
        //String dataBasePass = usersService.findByUsername(username).getPassword();
        //check if the user does not exists show message
        //else check if the username exists
        //else use SHA Hashing
//        String salt = passwordService.generateSalt(512).get();
//        String key = passwordService.hashPassword(password, salt).get();
//        
//        boolean verify = passwordService.verifyPassword(password, key, salt);
  
        
//        String hash1 = get_SHA_512_SecurePassword(password);
//        String hash2 = get_SHA_512_SecurePassword(password);
//        Boolean equal = hash1.equals(hash2);


        //String securePassword = get_SHA_256_SecurePassword(password);
//        if(dataBasePass.equals(securePassword)){
//            //redirect to index page
//        }
//        else{
//            //show message that the pass doesn't match
//        }
        //todo: read from database and check for match
        //if a match create new user
        if(user != null){ //redirect
            if(user.getPassword().equals(password))
               // externalContext.getSessionMap().put("user", user); //undo on logout
                return "templates/main.xhtml?faces-redirect=true";
        }
        
        resetText();
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
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops, wrong username or password","Oops, wrong username or password"));
        return "";
    }
    private void resetUser(){
        user = null;
        resetText();
    }
    private void resetText(){
        username=null;
        password=null;
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
    
    
//    private static String get_SHA_512_SecurePassword(String passwordToHash)
//    {
//        String generatedPassword = null;
//        try {
//            byte[] salt = salt;
//            MessageDigest md = MessageDigest.getInstance("SHA-512");
//            md.update(salt);
//            byte[] bytes = md.digest(passwordToHash.getBytes());
//            
//            //convert byte password ro string
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i< bytes.length ;i++)
//            {
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            generatedPassword = sb.toString();
//        }
//        catch (NoSuchAlgorithmException e)
//        {
//            e.printStackTrace();
//        }
//        return generatedPassword;
//        
//    }
    
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
    private String loginAction(){
        return "index.xhtml?faces-redirect=true";
    }
    
    private Boolean checkLogin(){
        return user != null;
    }
    
}
