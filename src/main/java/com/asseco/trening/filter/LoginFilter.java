///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.asseco.trening.filter;
//
//import com.asseco.trening.model.Users;
//import java.io.IOException;
//import java.util.logging.Logger;
//import javax.faces.application.ResourceHandler;
//import javax.faces.context.FacesContext;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.websocket.Session;
//
///**
// *
// * @author j0van
// */
//
//@WebFilter(filterName = "LoginFilter", urlPatterns = { "*.xhtml" })
//public class LoginFilter implements Filter{
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//
//	}
//        
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
//    
//    }
//        
//    private static final String AJAX_REDIRECT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
//        + "<partial-response><redirect url=\"%s\"></redirect></partial-response>";
//
////   @Override
////    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
////        HttpServletRequest request = (HttpServletRequest) req;
////        HttpServletResponse response = (HttpServletResponse) res;
////        HttpSession session = request.getSession(false);
////        String loginURL = request.getContextPath() + "/login.xhtml";
////
////        boolean loggedIn = (session != null) && (session.getAttribute("user") != null);
////        boolean loginRequest = request.getRequestURI().equals(loginURL);
////        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
////        boolean ajaxRequest = "partial/ajax".equals(request.getHeader("Faces-Request"));
////
////        if (loggedIn || loginRequest || resourceRequest) {
////            if (!resourceRequest) { // Prevent browser from caching restricted resources. See also https://stackoverflow.com/q/4194207/157882
////                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
////                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
////                response.setDateHeader("Expires", 0); // Proxies.
////            }
////
////            chain.doFilter(req, res); // So, just continue request.
////        }
////        else if (ajaxRequest) {
////            response.setContentType("text/xml");
////            response.setCharacterEncoding("UTF-8");
////            response.getWriter().printf(AJAX_REDIRECT_XML, loginURL); // So, return special XML response instructing JSF ajax to send a redirect.
////        }
////        else {
////            response.sendRedirect(loginURL); // So, just perform standard synchronous redirect.
////        }
////    }
//        
//        
//
////    @Override
////    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
////        
////        try{
////
////            HttpServletRequest hreq = (HttpServletRequest) request;
////            HttpServletResponse hres = (HttpServletResponse) response;
////            HttpSession session = hreq.getSession(false);
////            Users sessionUser = (Users)session.getAttribute("user");
////            
////            String reqURI = hreq.getRequestURI();
////            //private static final Logger logger = Logger.getLogger(LoginFilter.class);
////            
////            if(session.getAttribute("user") == null){
////                hres.sendRedirect(hreq.getContextPath() + "/login.xhtml");
////            }
////            else{
////                chain.doFilter(request, response);
////            }
////        } 
////        catch(NullPointerException e){
////            
////            System.out.println(e.getMessage());
////        }
////    }
//        
//        
//
////	@Override
////	public void doFilter(ServletRequest request, ServletResponse response,
////			FilterChain chain) throws IOException, ServletException {
////		try {
////
////			HttpServletRequest reqt = (HttpServletRequest) request;
////			HttpServletResponse resp = (HttpServletResponse) response;
////			HttpSession ses = reqt.getSession(false);
////
////			String reqURI = reqt.getRequestURI();
////			if (reqURI.contains("/login.xhtml")
////					|| (ses != null && ses.getAttribute("username") != null)
////					|| reqURI.contains("/public/")
////					|| reqURI.contains("javax.faces.resource"))
////				chain.doFilter(request, response);
////			else
////				resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
////		} catch (Exception e) {
////			System.out.println(e.getMessage());
////		}
////	}
//
//	@Override
//	public void destroy() {
//
//	}
//    
//}
