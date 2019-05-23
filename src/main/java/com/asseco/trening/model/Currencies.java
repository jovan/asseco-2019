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
import javax.persistence.Lob;
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
@Table(name = "currencies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currencies.findAll", query = "SELECT c FROM Currencies c")
    , @NamedQuery(name = "Currencies.findByCurrency", query = "SELECT c FROM Currencies c WHERE c.currency = :currency")
    , @NamedQuery(name = "Currencies.findByName", query = "SELECT c FROM Currencies c WHERE c.name = :name")
    , @NamedQuery(name = "Currencies.findBySymbol", query = "SELECT c FROM Currencies c WHERE c.symbol = :symbol")})
public class Currencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Currency")
    private String currency;
    @Size(max = 30)
    @Column(name = "Name")
    private String name;
    @Lob
    @Column(name = "Image")
    private byte[] image;
    @Size(max = 5)
    @Column(name = "Symbol")
    private String symbol;
    @OneToMany(mappedBy = "currency")
    private Collection<Postingentries> postingentriesCollection;
    @OneToMany(mappedBy = "currency")
    private Collection<Accounts> accountsCollection;
    @OneToMany(mappedBy = "currency")
    private Collection<Transactions> transactionsCollection;

    public Currencies() {
    }

    public Currencies(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @XmlTransient
    public Collection<Postingentries> getPostingentriesCollection() {
        return postingentriesCollection;
    }

    public void setPostingentriesCollection(Collection<Postingentries> postingentriesCollection) {
        this.postingentriesCollection = postingentriesCollection;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
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
        hash += (currency != null ? currency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currencies)) {
            return false;
        }
        Currencies other = (Currencies) object;
        if ((this.currency == null && other.currency != null) || (this.currency != null && !this.currency.equals(other.currency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asseco.trening.model.Currencies[ currency=" + currency + " ]";
    }
    
}
