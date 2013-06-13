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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "picture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Picture.findAll", query = "SELECT p FROM Picture p"),
    @NamedQuery(name = "Picture.findByPictureId", query = "SELECT p FROM Picture p WHERE p.pictureId = :pictureId"),
    @NamedQuery(name = "Picture.findByPicturePos", query = "SELECT p FROM Picture p WHERE p.picturePos = :picturePos")})
public class Picture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "picture_id")
    private String pictureId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "picture_pos")
    private String picturePos;
    @ManyToMany(mappedBy = "pictureCollection")
    private Collection<Passage> passageCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pictureId")
    private Spotpicture spotpicture;

    public Picture() {
    }

    public Picture(String pictureId) {
        this.pictureId = pictureId;
    }

    public Picture(String pictureId, String picturePos) {
        this.pictureId = pictureId;
        this.picturePos = picturePos;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPicturePos() {
        return picturePos;
    }

    public void setPicturePos(String picturePos) {
        this.picturePos = picturePos;
    }

    @XmlTransient
    public Collection<Passage> getPassageCollection() {
        return passageCollection;
    }

    public void setPassageCollection(Collection<Passage> passageCollection) {
        this.passageCollection = passageCollection;
    }

    public Spotpicture getSpotpicture() {
        return spotpicture;
    }

    public void setSpotpicture(Spotpicture spotpicture) {
        this.spotpicture = spotpicture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pictureId != null ? pictureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Picture)) {
            return false;
        }
        Picture other = (Picture) object;
        if ((this.pictureId == null && other.pictureId != null) || (this.pictureId != null && !this.pictureId.equals(other.pictureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.Picture[ pictureId=" + pictureId + " ]";
    }
    
}
