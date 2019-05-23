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
@Table(name = "accountclasses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountclasses.findAll", query = "SELECT a FROM Accountclasses a")
    , @NamedQuery(name = "Accountclasses.findById", query = "SELECT a FROM Accountclasses a WHERE a.id = :id")
    , @NamedQuery(name = "Accountclasses.findByName", query = "SELECT a FROM Accountclasses a WHERE a.name = :name")
    , @NamedQuery(name = "Accountclasses.findByDescription", query = "SELECT a FROM Accountclasses a WHERE a.description = :description")
    , @NamedQuery(name = "Accountclasses.findByType", query = "SELECT a FROM Accountclasses a WHERE a.type = :type")
    , @NamedQuery(name = "Accountclasses.findByIsCashAccount", query = "SELECT a FROM Accountclasses a WHERE a.isCashAccount = :isCashAccount")
    , @NamedQuery(name = "Accountclasses.findByIsCurrentAccount", query = "SELECT a FROM Accountclasses a WHERE a.isCurrentAccount = :isCurrentAccount")
    , @NamedQuery(name = "Accountclasses.findByIsDepositAccount", query = "SELECT a FROM Accountclasses a WHERE a.isDepositAccount = :isDepositAccount")
    , @NamedQuery(name = "Accountclasses.findByIsCreditAccount", query = "SELECT a FROM Accountclasses a WHERE a.isCreditAccount = :isCreditAccount")})
public class Accountclasses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    @Size(max = 30)
    @Column(name = "Name")
    private String name;
    @Size(max = 100)
    @Column(name = "Description")
    private String description;
    @Column(name = "Type")
    private Integer type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsCashAccount")
    private int isCashAccount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsCurrentAccount")
    private int isCurrentAccount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsDepositAccount")
    private int isDepositAccount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsCreditAccount")
    private int isCreditAccount;
    @OneToMany(mappedBy = "classId")
    private Collection<Accounttypes> accounttypesCollection;
    @OneToMany(mappedBy = "accountClassDebit")
    private Collection<Transactiontypes> transactiontypesCollection;
    @OneToMany(mappedBy = "accountClaassCredit")
    private Collection<Transactiontypes> transactiontypesCollection1;

    public Accountclasses() {
    }

    public Accountclasses(Long id) {
        this.id = id;
    }

    public Accountclasses(Long id, int isCashAccount, int isCurrentAccount, int isDepositAccount, int isCreditAccount) {
        this.id = id;
        this.isCashAccount = isCashAccount;
        this.isCurrentAccount = isCurrentAccount;
        this.isDepositAccount = isDepositAccount;
        this.isCreditAccount = isCreditAccount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getIsCashAccount() {
        return isCashAccount;
    }

    public void setIsCashAccount(int isCashAccount) {
        this.isCashAccount = isCashAccount;
    }

    public int getIsCurrentAccount() {
        return isCurrentAccount;
    }

    public void setIsCurrentAccount(int isCurrentAccount) {
        this.isCurrentAccount = isCurrentAccount;
    }

    public int getIsDepositAccount() {
        return isDepositAccount;
    }

    public void setIsDepositAccount(int isDepositAccount) {
        this.isDepositAccount = isDepositAccount;
    }

    public int getIsCreditAccount() {
        return isCreditAccount;
    }

    public void setIsCreditAccount(int isCreditAccount) {
        this.isCreditAccount = isCreditAccount;
    }

    @XmlTransient
    public Collection<Accounttypes> getAccounttypesCollection() {
        return accounttypesCollection;
    }

    public void setAccounttypesCollection(Collection<Accounttypes> accounttypesCollection) {
        this.accounttypesCollection = accounttypesCollection;
    }

    @XmlTransient
    public Collection<Transactiontypes> getTransactiontypesCollection() {
        return transactiontypesCollection;
    }

    public void setTransactiontypesCollection(Collection<Transactiontypes> transactiontypesCollection) {
        this.transactiontypesCollection = transactiontypesCollection;
    }

    @XmlTransient
    public Collection<Transactiontypes> getTransactiontypesCollection1() {
        return transactiontypesCollection1;
    }

    public void setTransactiontypesCollection1(Collection<Transactiontypes> transactiontypesCollection1) {
        this.transactiontypesCollection1 = transactiontypesCollection1;
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
        if (!(object instanceof Accountclasses)) {
            return false;
        }
        Accountclasses other = (Accountclasses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asseco.trening.model.Accountclasses[ id=" + id + " ]";
    }
    
}
