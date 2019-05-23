/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findById", query = "SELECT a FROM Accounts a WHERE a.id = :id")
    , @NamedQuery(name = "Accounts.findByAccountNumber", query = "SELECT a FROM Accounts a WHERE a.accountNumber = :accountNumber")
    , @NamedQuery(name = "Accounts.findByStatus", query = "SELECT a FROM Accounts a WHERE a.status = :status")
    , @NamedQuery(name = "Accounts.findByBlocked", query = "SELECT a FROM Accounts a WHERE a.blocked = :blocked")
    , @NamedQuery(name = "Accounts.findByBalance", query = "SELECT a FROM Accounts a WHERE a.balance = :balance")
    , @NamedQuery(name = "Accounts.findByOverdraftLimit", query = "SELECT a FROM Accounts a WHERE a.overdraftLimit = :overdraftLimit")
    , @NamedQuery(name = "Accounts.findByAmountOnHold", query = "SELECT a FROM Accounts a WHERE a.amountOnHold = :amountOnHold")
    , @NamedQuery(name = "Accounts.findByAvailableBalance", query = "SELECT a FROM Accounts a WHERE a.availableBalance = :availableBalance")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    
    @Size(max = 30)
    @Column(name = "AccountNumber")
    private String accountNumber;
    
    @Size(max = 1)
    @Column(name = "Status")
    private String status;
    
    @Column(name = "Blocked")
    private Boolean blocked;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Balance")
    private BigDecimal balance;
    
    @Column(name = "OverdraftLimit")
    private BigDecimal overdraftLimit;
    
    @Column(name = "AmountOnHold")
    private BigDecimal amountOnHold;
    
    @Column(name = "AvailableBalance")
    private BigDecimal availableBalance;
    
    @OneToMany(mappedBy = "accountId")
    private Collection<Postingentries> postingentriesCollection;
    
    @OneToMany(mappedBy = "contraAccountId")
    private Collection<Postingentries> postingentriesCollection1;
    
    @JoinColumn(name = "TypeId", referencedColumnName = "Id")
    @ManyToOne
    private Accounttypes typeId;
    
    @JoinColumn(name = "ClientId", referencedColumnName = "Id")
    @ManyToOne
    private Clients clientId;
    
    @JoinColumn(name = "Currency", referencedColumnName = "Currency")
    @ManyToOne
    private Currencies currency;
    
    @OneToMany(mappedBy = "accountIdDebit")
    private Collection<Transactions> transactionsCollection;
    
    @OneToMany(mappedBy = "accountIdCredit")
    private Collection<Transactions> transactionsCollection1;
    
    @OneToMany(mappedBy = "cashAccountId")
    private Collection<Users> usersCollection;

    public Accounts() {
    }

    public Accounts(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public BigDecimal getAmountOnHold() {
        return amountOnHold;
    }

    public void setAmountOnHold(BigDecimal amountOnHold) {
        this.amountOnHold = amountOnHold;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    @XmlTransient
    public Collection<Postingentries> getPostingentriesCollection() {
        return postingentriesCollection;
    }

    public void setPostingentriesCollection(Collection<Postingentries> postingentriesCollection) {
        this.postingentriesCollection = postingentriesCollection;
    }

    @XmlTransient
    public Collection<Postingentries> getPostingentriesCollection1() {
        return postingentriesCollection1;
    }

    public void setPostingentriesCollection1(Collection<Postingentries> postingentriesCollection1) {
        this.postingentriesCollection1 = postingentriesCollection1;
    }

    public Accounttypes getTypeId() {
        return typeId;
    }

    public void setTypeId(Accounttypes typeId) {
        this.typeId = typeId;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection1() {
        return transactionsCollection1;
    }

    public void setTransactionsCollection1(Collection<Transactions> transactionsCollection1) {
        this.transactionsCollection1 = transactionsCollection1;
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
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asseco.trening.model.Accounts[ id=" + id + " ]";
    }
    
}
