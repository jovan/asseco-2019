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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "transactiontypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactiontypes.findAll", query = "SELECT t FROM Transactiontypes t")
    , @NamedQuery(name = "Transactiontypes.findById", query = "SELECT t FROM Transactiontypes t WHERE t.id = :id")
    , @NamedQuery(name = "Transactiontypes.findByName", query = "SELECT t FROM Transactiontypes t WHERE t.name = :name")
    , @NamedQuery(name = "Transactiontypes.findByDescription", query = "SELECT t FROM Transactiontypes t WHERE t.description = :description")
    , @NamedQuery(name = "Transactiontypes.findByReflectsAmountOnHold", query = "SELECT t FROM Transactiontypes t WHERE t.reflectsAmountOnHold = :reflectsAmountOnHold")
    , @NamedQuery(name = "Transactiontypes.findByHashfee", query = "SELECT t FROM Transactiontypes t WHERE t.hashfee = :hashfee")})
public class Transactiontypes implements Serializable {

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
    
    @Column(name = "ReflectsAmountOnHold")
    private Boolean reflectsAmountOnHold;
    
    @Column(name = "Hashfee")
    private Boolean hashfee;
    
    @JoinColumn(name = "AccountClassDebit", referencedColumnName = "Id")
    @ManyToOne
    private Accountclasses accountClassDebit;
    
    @JoinColumn(name = "AccountClaassCredit", referencedColumnName = "Id")
    @ManyToOne
    private Accountclasses accountClaassCredit;
    
    @OneToMany(mappedBy = "transactionTypeId")
    private Collection<Transactions> transactionsCollection;

    public Transactiontypes() {
    }

    public Transactiontypes(Long id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getReflectsAmountOnHold() {
        return reflectsAmountOnHold;
    }

    public void setReflectsAmountOnHold(Boolean reflectsAmountOnHold) {
        this.reflectsAmountOnHold = reflectsAmountOnHold;
    }

    public Boolean getHashfee() {
        return hashfee;
    }

    public void setHashfee(Boolean hashfee) {
        this.hashfee = hashfee;
    }

    public Accountclasses getAccountClassDebit() {
        return accountClassDebit;
    }

    public void setAccountClassDebit(Accountclasses accountClassDebit) {
        this.accountClassDebit = accountClassDebit;
    }

    public Accountclasses getAccountClaassCredit() {
        return accountClaassCredit;
    }

    public void setAccountClaassCredit(Accountclasses accountClaassCredit) {
        this.accountClaassCredit = accountClaassCredit;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
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
        if (!(object instanceof Transactiontypes)) {
            return false;
        }
        Transactiontypes other = (Transactiontypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asseco.trening.model.Transactiontypes[ id=" + id + " ]";
    }
    
}
