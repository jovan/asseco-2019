/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.filter;

import com.asseco.trening.controller.LoginController;
import com.asseco.trening.model.Users;
import java.io.IOException;
import java.util.logging.Logger;
import javax.faces.application.ResourceHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.slf4j.LoggerFactory;


/**
 *
 * @author j0van
 */
@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter{

    private static final org.slf4j.Logger LOGGER =
       LoggerFactory.getLogger(LoginFilter.class);
    
    public static final String LOGIN_PAGE = "/login.xhtml";
    public static final String HOME_PAGE = "/index.xhtml";
    


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        
        //managed bean name is exactly the session attribute name
//        LoginController loginController = (LoginController) httpServletRequest.getSession().getAttribute("loginController");
        String context = httpServletRequest.getContextPath();
        
        HttpSession ses = getSession();
        Object o = request.getAttribute("user");
        
        if(ses != null){

            //LOGGER.debug("user is not logged in");
            if(ses.getAttribute("user")!=null){
                if(context.equals("/trening") || context.equals("/trening"+LOGIN_PAGE)){
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + HOME_PAGE);
                    System.out.println("LoggedIn Redirect " + context);
                }
                else { //prodolzi normalno
                    System.out.println("LoggedIn continue " + context);    
                    chain.doFilter(request, response);
                } 
            }
            else{
                System.out.println("Not Logged In Send Redirect " + context);    
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
            }
        } 
        else{
            chain.doFilter(request, response);
            System.out.println("LoginController NULL " + context);    
            //httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
        }
    }
    
    
        private static HttpSession getSession() {
            try{
                return (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
                }
            catch(NullPointerException e){
                
            }
            return null;
    }
        
//    private static HttpServletRequest getRequest() {
//            try{
//                return (HttpSession) FacesContext.getCurrentInstance()
//                    .getExternalContext().getSession(false);
//                }
//            catch(NullPointerException e){
//                
//            }
//            return null;
//    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // LOGGER.debug("loginFilter initialized");
    }
    
    @Override
    public void destroy() {
        
    }
}
