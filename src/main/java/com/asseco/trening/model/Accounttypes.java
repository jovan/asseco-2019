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
@Table(name = "accounttypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounttypes.findAll", query = "SELECT a FROM Accounttypes a")
    , @NamedQuery(name = "Accounttypes.findById", query = "SELECT a FROM Accounttypes a WHERE a.id = :id")
    , @NamedQuery(name = "Accounttypes.findByName", query = "SELECT a FROM Accounttypes a WHERE a.name = :name")
    , @NamedQuery(name = "Accounttypes.findByDescription", query = "SELECT a FROM Accounttypes a WHERE a.description = :description")})
public class Accounttypes implements Serializable {

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
    @JoinColumn(name = "ClassId", referencedColumnName = "Id")
    @ManyToOne
    private Accountclasses classId;
    @OneToMany(mappedBy = "typeId")
    private Collection<Accounts> accountsCollection;

    public Accounttypes() {
    }

    public Accounttypes(Long id) {
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

    public Accountclasses getClassId() {
        return classId;
    }

    public void setClassId(Accountclasses classId) {
        this.classId = classId;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
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
        if (!(object instanceof Accounttypes)) {
            return false;
        }
        Accounttypes other = (Accounttypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asseco.trening.model.Accounttypes[ id=" + id + " ]";
    }
    
}
