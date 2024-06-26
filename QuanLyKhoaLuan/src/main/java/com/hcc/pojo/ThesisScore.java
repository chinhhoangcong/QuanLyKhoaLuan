/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "thesis_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThesisScore.findAll", query = "SELECT t FROM ThesisScore t"),
    @NamedQuery(name = "ThesisScore.findById", query = "SELECT t FROM ThesisScore t WHERE t.id = :id"),
    @NamedQuery(name = "ThesisScore.findByScore", query = "SELECT t FROM ThesisScore t WHERE t.score = :score"),
    @NamedQuery(name = "ThesisScore.findByCreatedDate", query = "SELECT t FROM ThesisScore t WHERE t.createdDate = :createdDate")})
public class ThesisScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "score")
    private String score;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "thesis_criteria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ThesisCriteria thesisCriteriaId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public ThesisScore() {
    }

    public ThesisScore(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ThesisCriteria getThesisCriteriaId() {
        return thesisCriteriaId;
    }

    public void setThesisCriteriaId(ThesisCriteria thesisCriteriaId) {
        this.thesisCriteriaId = thesisCriteriaId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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
        if (!(object instanceof ThesisScore)) {
            return false;
        }
        ThesisScore other = (ThesisScore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hcc.pojo.ThesisScore[ id=" + id + " ]";
    }
    
}
