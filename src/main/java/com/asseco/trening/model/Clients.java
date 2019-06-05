/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LT5
 */
@Entity
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c")
    , @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id")
    , @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name")
    , @NamedQuery(name = "Clients.findByType", query = "SELECT c FROM Clients c WHERE c.type = :type")
    , @NamedQuery(name = "Clients.findByIdentificationNumber", query = "SELECT c FROM Clients c WHERE c.identificationNumber = :identificationNumber")
    , @NamedQuery(name = "Clients.findByAddress", query = "SELECT c FROM Clients c WHERE c.address = :address")
    , @NamedQuery(name = "Clients.findByTel", query = "SELECT c FROM Clients c WHERE c.tel = :tel")
    , @NamedQuery(name = "Clients.findByMob", query = "SELECT c FROM Clients c WHERE c.mob = :mob")
    , @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email")
    , @NamedQuery(name = "Clients.findByWeb", query = "SELECT c FROM Clients c WHERE c.web = :web")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    
    @Size(max = 200)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Type")
    private Integer type;
    
    @Size(max = 36)
    @Column(name = "IdentificationNumber")
    private String identificationNumber;
    
    @Size(max = 100)
    @Column(name = "Address")
    private String address;
    
    @Size(max = 30)
    @Column(name = "Tel")
    private String tel;
    
    @Size(max = 30)
    @Column(name = "Mob")
    private String mob;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "Email")
    private String email;
    
    @Size(max = 100)
    @Column(name = "Web")
    private String web;
    
    @OneToMany(mappedBy = "clientId")
    private Collection<Accounts> accountsCollection;
    
    @OneToMany(mappedBy = "clientId")
    private Collection<Users> usersCollection;

    public Clients() {
    }

    public Clients(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asseco.trening.model.Clients[ id=" + id + " ]";
    }
    
}
