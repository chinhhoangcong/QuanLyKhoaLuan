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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "thesis_criteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThesisCriteria.findAll", query = "SELECT t FROM ThesisCriteria t"),
    @NamedQuery(name = "ThesisCriteria.findById", query = "SELECT t FROM ThesisCriteria t WHERE t.id = :id"),
    @NamedQuery(name = "ThesisCriteria.findByTotalScore", query = "SELECT t FROM ThesisCriteria t WHERE t.totalScore = :totalScore")})
public class ThesisCriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_score")
    private Float totalScore;
    @OneToMany(mappedBy = "thesisCriteriaId")
    private Set<ThesisScore> thesisScoreSet;
    @JoinColumn(name = "criteria_id", referencedColumnName = "id")
    @ManyToOne
    private Criteria criteriaId;
    @JoinColumn(name = "thesis_id", referencedColumnName = "id")
    @ManyToOne
    private Thesis thesisId;

    public ThesisCriteria() {
    }

    public ThesisCriteria(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    @XmlTransient
    public Set<ThesisScore> getThesisScoreSet() {
        return thesisScoreSet;
    }

    public void setThesisScoreSet(Set<ThesisScore> thesisScoreSet) {
        this.thesisScoreSet = thesisScoreSet;
    }

    public Criteria getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Criteria criteriaId) {
        this.criteriaId = criteriaId;
    }

    public Thesis getThesisId() {
        return thesisId;
    }

    public void setThesisId(Thesis thesisId) {
        this.thesisId = thesisId;
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
        if (!(object instanceof ThesisCriteria)) {
            return false;
        }
        ThesisCriteria other = (ThesisCriteria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hcc.pojo.ThesisCriteria[ id=" + id + " ]";
    }
    
}
