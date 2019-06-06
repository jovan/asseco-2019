/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.model;

import com.asseco.trening.enumeration.TransactionItnostEnum;
import com.asseco.trening.enumeration.TransactionStatusEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LT5
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id")
    , @NamedQuery(name = "Transactions.findByEntyDate", query = "SELECT t FROM Transactions t WHERE t.entyDate = :entyDate")
    , @NamedQuery(name = "Transactions.findByDate", query = "SELECT t FROM Transactions t WHERE t.date = :date")
    , @NamedQuery(name = "Transactions.findByFee", query = "SELECT t FROM Transactions t WHERE t.fee = :fee")
    , @NamedQuery(name = "Transactions.findByAmount", query = "SELECT t FROM Transactions t WHERE t.amount = :amount")
    , @NamedQuery(name = "Transactions.findByDescription", query = "SELECT t FROM Transactions t WHERE t.description = :description")
    , @NamedQuery(name = "Transactions.findByStatus", query = "SELECT t FROM Transactions t WHERE t.status = :status")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    
    @Column(name = "EntyDate")
    @Temporal(TemporalType.DATE)
    private Date entyDate; // = new Date() -> at the moment
    
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Fee")
    private BigDecimal fee;
    
    @Column(name = "Amount")
    private BigDecimal amount;
    
    @Size(max = 100)
    @Column(name = "Description")
    private String description;
    
    @Column(name = "Status")
    private TransactionStatusEnum status;
    
    @Column(name = "Itnost")
    private TransactionItnostEnum itnost;
    
    @OneToMany(mappedBy = "transactionId")
    private Collection<Postingentries> postingentriesCollection;
    
    @JoinColumn(name = "AccountIdDebit", referencedColumnName = "Id")
    @ManyToOne
    private Accounts accountIdDebit;
    
    @JoinColumn(name = "AccountIdCredit", referencedColumnName = "Id")
    @ManyToOne
    private Accounts accountIdCredit;
    
    @JoinColumn(name = "Currency", referencedColumnName = "Currency")
    @ManyToOne
    private Currencies currency;
    
    @JoinColumn(name = "TransactionTypeId", referencedColumnName = "Id")
    @ManyToOne
    private Transactiontypes transactionTypeId;
    
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne
    private Users userId;

    public Transactions() {
    }

    public Transactions(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntyDate() {
        return entyDate;
    }

    public void setEntyDate(Date entyDate) {
        this.entyDate = entyDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public TransactionItnostEnum getItnost() {
        return itnost;
    }

    public void setItnost(TransactionItnostEnum itnost) {
        this.itnost = itnost;
    }



    @XmlTransient
    public Collection<Postingentries> getPostingentriesCollection() {
        return postingentriesCollection;
    }

    public void setPostingentriesCollection(Collection<Postingentries> postingentriesCollection) {
        this.postingentriesCollection = postingentriesCollection;
    }

    public Accounts getAccountIdDebit() {
        return accountIdDebit;
    }

    public void setAccountIdDebit(Accounts accountIdDebit) {
        this.accountIdDebit = accountIdDebit;
    }

    public Accounts getAccountIdCredit() {
        return accountIdCredit;
    }

    public void setAccountIdCredit(Accounts accountIdCredit) {
        this.accountIdCredit = accountIdCredit;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    public Transactiontypes getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Transactiontypes transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asseco.trening.model.Transactions[ id=" + id + " ]";
    }
    
}
