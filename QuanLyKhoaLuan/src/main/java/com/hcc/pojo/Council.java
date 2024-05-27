/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author ACER
 */
@Entity
@Table(name = "council")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Council.findAll", query = "SELECT c FROM Council c"),
    @NamedQuery(name = "Council.findById", query = "SELECT c FROM Council c WHERE c.id = :id"),
    @NamedQuery(name = "Council.findByName", query = "SELECT c FROM Council c WHERE c.name = :name"),
    @NamedQuery(name = "Council.findByActive", query = "SELECT c FROM Council c WHERE c.active = :active"),
    @NamedQuery(name = "Council.findByCreatedDate", query = "SELECT c FROM Council c WHERE c.createdDate = :createdDate")})
public class Council implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private Short active;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(mappedBy = "councilId")
    private Set<Thesis> thesisSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "councilId")
    private Set<CouncilTeacher> councilTeacherSet;

    public Council() {
    }

    public Council(Integer id) {
        this.id = id;
    }

    public Council(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Set<Thesis> getThesisSet() {
        return thesisSet;
    }

    public void setThesisSet(Set<Thesis> thesisSet) {
        this.thesisSet = thesisSet;
    }

    @XmlTransient
    public Set<CouncilTeacher> getCouncilTeacherSet() {
        return councilTeacherSet;
    }

    public void setCouncilTeacherSet(Set<CouncilTeacher> councilTeacherSet) {
        this.councilTeacherSet = councilTeacherSet;
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
        if (!(object instanceof Council)) {
            return false;
        }
        Council other = (Council) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hcc.pojo.Council[ id=" + id + " ]";
    }
    
}
