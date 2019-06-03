/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.controller;

import com.asseco.trening.enumeration.ZanimanjeEnum;
import com.asseco.trening.model.TestKorisnik;
import com.asseco.trening.service.TestKorisniciService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author igor.stojanoski
 */
@Stateless
@Named
public class TestKorisniciController {
    
    @Inject
    private TestKorisniciService testKorisniciService;
    
    TestKorisnik nov = new TestKorisnik();
    
    private ZanimanjeEnum[] profession;
    
    private List<TestKorisnik> korisnici;
    
    @PostConstruct
    public void init(){
        profession = ZanimanjeEnum.values();
        korisnici = testKorisniciService.findAll();
    }
    
//    public List<TestKorisnik> findAll(){
//        return testKorisniciService.findAll();
//    }
    
     
//    @PostConstruct
//    public void init() {
//        cars = service.createCars(10);
//    }
    
    public String test(){
         return "/login.xhtml?faces-redirect=true";
    }

    public void kreirajNovKorisnik(){
    
        try {
            testKorisniciService.kreirajNovKorisnik(nov);
            korisnici = testKorisniciService.findAll();
        } catch (Exception ex) {
            System.out.println(ex);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Greska"));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uspesno dodanen nov korisnik"));
        nov = new TestKorisnik();
    }

    public TestKorisniciService getTestKorisniciService() {
        return testKorisniciService;
    }

    public void setTestKorisniciService(TestKorisniciService testKorisniciService) {
        this.testKorisniciService = testKorisniciService;
    }

    public ZanimanjeEnum[] getProfession() {
        return profession;
    }

    public void setProfession(ZanimanjeEnum[] profession) {
        this.profession = profession;
    }

    public TestKorisnik getNov() {
        return nov;
    }

    public void setNov(TestKorisnik nov) {
        this.nov = nov;
    }

    public List<TestKorisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<TestKorisnik> korisnici) {
        this.korisnici = korisnici;
    }
    
    
}
