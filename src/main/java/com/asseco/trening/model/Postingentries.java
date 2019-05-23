/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LT5
 */
@Entity
@Table(name = "postingentries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postingentries.findAll", query = "SELECT p FROM Postingentries p")
    , @NamedQuery(name = "Postingentries.findById", query = "SELECT p FROM Postingentries p WHERE p.id = :id")
    , @NamedQuery(name = "Postingentries.findByDebitCredit", query = "SELECT p FROM Postingentries p WHERE p.debitCredit = :debitCredit")
    , @NamedQuery(name = "Postingentries.findByAmount", query = "SELECT p FROM Postingentries p WHERE p.amount = :amount")
    , @NamedQuery(name = "Postingentries.findByStatementNo", query = "SELECT p FROM Postingentries p WHERE p.statementNo = :statementNo")})
public class Postingentries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    @Column(name = "DebitCredit")
    private Short debitCredit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Amount")
    private BigDecimal amount;
    @Column(name = "StatementNo")
    private Integer statementNo;
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    @ManyToOne
    private Accounts accountId;
    @JoinColumn(name = "ContraAccountId", referencedColumnName = "Id")
    @ManyToOne
    private Accounts contraAccountId;
    @JoinColumn(name = "Currency", referencedColumnName = "Currency")
    @ManyToOne
    private Currencies currency;
    @JoinColumn(name = "TransactionId", referencedColumnName = "Id")
    @ManyToOne
    private Transactions transactionId;

    public Postingentries() {
    }

    public Postingentries(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getDebitCredit() {
        return debitCredit;
    }

    public void setDebitCredit(Short debitCredit) {
        this.debitCredit = debitCredit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatementNo() {
        return statementNo;
    }

    public void setStatementNo(Integer statementNo) {
        this.statementNo = statementNo;
    }

    public Accounts getAccountId() {
        return accountId;
    }

    public void setAccountId(Accounts accountId) {
        this.accountId = accountId;
    }

    public Accounts getContraAccountId() {
        return contraAccountId;
    }

    public void setContraAccountId(Accounts contraAccountId) {
        this.contraAccountId = contraAccountId;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    public Transactions getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transactions transactionId) {
        this.transactionId = transactionId;
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
        if (!(object instanceof Postingentries)) {
            return false;
        }
        Postingentries other = (Postingentries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asseco.trening.model.Postingentries[ id=" + id + " ]";
    }
    
}
