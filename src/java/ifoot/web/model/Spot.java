/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifoot.web.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Ã¨µÄÓã¶ù
 */
@Entity
@Table(name = "spot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spot.findAll", query = "SELECT s FROM Spot s"),
    @NamedQuery(name = "Spot.findBySpotId", query = "SELECT s FROM Spot s WHERE s.spotId = :spotId"),
    @NamedQuery(name = "Spot.findBySpotName", query = "SELECT s FROM Spot s WHERE s.spotName = :spotName"),
    @NamedQuery(name = "Spot.findByGrade", query = "SELECT s FROM Spot s WHERE s.grade = :grade"),
    @NamedQuery(name = "Spot.findByClassification", query = "SELECT s FROM Spot s WHERE s.classification = :classification"),
    @NamedQuery(name = "Spot.findByPictureNumber", query = "SELECT s FROM Spot s WHERE s.pictureNumber = :pictureNumber"),
    @NamedQuery(name = "Spot.findByPassageNumber", query = "SELECT s FROM Spot s WHERE s.passageNumber = :passageNumber")})
public class Spot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "spot_id")
    private String spotId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "spot_name")
    private String spotName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "spot_introduction")
    private String spotIntroduction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "grade")
    private String grade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "classification")
    private String classification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "picture_number")
    private int pictureNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "passage_number")
    private int passageNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
    private Collection<Spotpicture> spotpictureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
    private Collection<Spotpassage> spotpassageCollection;

    public Spot() {
    }

    public Spot(String spotId) {
        this.spotId = spotId;
    }

    public Spot(String spotId, String spotName, String spotIntroduction, String grade, String classification, int pictureNumber, int passageNumber) {
        this.spotId = spotId;
        this.spotName = spotName;
        this.spotIntroduction = spotIntroduction;
        this.grade = grade;
        this.classification = classification;
        this.pictureNumber = pictureNumber;
        this.passageNumber = passageNumber;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotIntroduction() {
        return spotIntroduction;
    }

    public void setSpotIntroduction(String spotIntroduction) {
        this.spotIntroduction = spotIntroduction;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(int pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    public int getPassageNumber() {
        return passageNumber;
    }

    public void setPassageNumber(int passageNumber) {
        this.passageNumber = passageNumber;
    }

    @XmlTransient
    public Collection<Spotpicture> getSpotpictureCollection() {
        return spotpictureCollection;
    }

    public void setSpotpictureCollection(Collection<Spotpicture> spotpictureCollection) {
        this.spotpictureCollection = spotpictureCollection;
    }

    @XmlTransient
    public Collection<Spotpassage> getSpotpassageCollection() {
        return spotpassageCollection;
    }

    public void setSpotpassageCollection(Collection<Spotpassage> spotpassageCollection) {
        this.spotpassageCollection = spotpassageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spotId != null ? spotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spot)) {
            return false;
        }
        Spot other = (Spot) object;
        if ((this.spotId == null && other.spotId != null) || (this.spotId != null && !this.spotId.equals(other.spotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.Spot[ spotId=" + spotId + " ]";
    }
    
}
