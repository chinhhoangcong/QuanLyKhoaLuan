/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "year")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Year.findAll", query = "SELECT y FROM Year y"),
    @NamedQuery(name = "Year.findById", query = "SELECT y FROM Year y WHERE y.id = :id"),
    @NamedQuery(name = "Year.findByYear", query = "SELECT y FROM Year y WHERE y.year = :year")})
public class Year implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;
    @ManyToMany(mappedBy = "yearSet")
    private Set<Major> majorSet;

    public Year() {
    }

    public Year(Integer id) {
        this.id = id;
    }

    public Year(Integer id, int year) {
        this.id = id;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @XmlTransient
    public Set<Major> getMajorSet() {
        return majorSet;
    }

    public void setMajorSet(Set<Major> majorSet) {
        this.majorSet = majorSet;
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
        if (!(object instanceof Year)) {
            return false;
        }
        Year other = (Year) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hcc.pojo.Year[ id=" + id + " ]";
    }
    
}
