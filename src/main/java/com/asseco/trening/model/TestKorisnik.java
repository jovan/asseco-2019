/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.model;

import com.asseco.trening.enumeration.ZanimanjeEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author igor.stojanoski
 */
@Entity
@Table(name = "TEST_KORISNICI")
public class TestKorisnik implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid-gen")
    @Column(name = "ID")
    private String entityId;

    @Column(name = "IME")
    private String ime;
    
    @Column(name = "PREZIME")
    private String prezime;
    
    @Column(name = "POL")
    private Boolean pol;
    
    @Column(name = "VOZRAST")
    private Integer vozrast;
    
    private String maticen;
    
    private String address;
    
    @Column(name = "PROFESSION")
    @Enumerated(EnumType.STRING)
    private ZanimanjeEnum profession;

    public String getMaticen() {
        return maticen;
    }

    public void setMaticen(String maticen) {
        this.maticen = maticen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ZanimanjeEnum getProfession() {
        return profession;
    }

    public void setProfession(ZanimanjeEnum profession) {
        this.profession = profession;
    }
            
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Boolean getPol() {
        return pol;
    }

    public void setPol(Boolean pol) {
        this.pol = pol;
    }

    public Integer getVozrast() {
        return vozrast;
    }

    public void setVozrast(Integer vozrast) {
        this.vozrast = vozrast;
    }
    
    
    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
    
}
