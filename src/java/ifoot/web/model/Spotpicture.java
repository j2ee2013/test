/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifoot.web.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ã¨µÄÓã¶ù
 */
@Entity
@Table(name = "spotpicture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spotpicture.findAll", query = "SELECT s FROM Spotpicture s"),
    @NamedQuery(name = "Spotpicture.findBySpotId", query = "SELECT s FROM Spotpicture s WHERE s.spotpicturePK.spotId = :spotId"),
    @NamedQuery(name = "Spotpicture.findByTable", query = "SELECT s FROM Spotpicture s WHERE s.spotpicturePK.table = :table")})
public class Spotpicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpotpicturePK spotpicturePK;
    @JoinColumn(name = "spot_id", referencedColumnName = "spot_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Spot spot;
    @JoinColumn(name = "picture_id", referencedColumnName = "picture_id")
    @OneToOne(optional = false)
    private Picture pictureId;

    public Spotpicture() {
    }

    public Spotpicture(SpotpicturePK spotpicturePK) {
        this.spotpicturePK = spotpicturePK;
    }

    public Spotpicture(String spotId, String table) {
        this.spotpicturePK = new SpotpicturePK(spotId, table);
    }

    public SpotpicturePK getSpotpicturePK() {
        return spotpicturePK;
    }

    public void setSpotpicturePK(SpotpicturePK spotpicturePK) {
        this.spotpicturePK = spotpicturePK;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Picture getPictureId() {
        return pictureId;
    }

    public void setPictureId(Picture pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spotpicturePK != null ? spotpicturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spotpicture)) {
            return false;
        }
        Spotpicture other = (Spotpicture) object;
        if ((this.spotpicturePK == null && other.spotpicturePK != null) || (this.spotpicturePK != null && !this.spotpicturePK.equals(other.spotpicturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.Spotpicture[ spotpicturePK=" + spotpicturePK + " ]";
    }
    
}
