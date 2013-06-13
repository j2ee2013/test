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
@Table(name = "spotpassage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spotpassage.findAll", query = "SELECT s FROM Spotpassage s"),
    @NamedQuery(name = "Spotpassage.findByIdSpot", query = "SELECT s FROM Spotpassage s WHERE s.spotpassagePK.idSpot = :idSpot"),
    @NamedQuery(name = "Spotpassage.findByTable", query = "SELECT s FROM Spotpassage s WHERE s.spotpassagePK.table = :table")})
public class Spotpassage implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpotpassagePK spotpassagePK;
    @JoinColumn(name = "id_spot", referencedColumnName = "spot_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Spot spot;
    @JoinColumn(name = "id_passage", referencedColumnName = "passage_id")
    @OneToOne(optional = false)
    private Passage idPassage;

    public Spotpassage() {
    }

    public Spotpassage(SpotpassagePK spotpassagePK) {
        this.spotpassagePK = spotpassagePK;
    }

    public Spotpassage(String idSpot, String table) {
        this.spotpassagePK = new SpotpassagePK(idSpot, table);
    }

    public SpotpassagePK getSpotpassagePK() {
        return spotpassagePK;
    }

    public void setSpotpassagePK(SpotpassagePK spotpassagePK) {
        this.spotpassagePK = spotpassagePK;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Passage getIdPassage() {
        return idPassage;
    }

    public void setIdPassage(Passage idPassage) {
        this.idPassage = idPassage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spotpassagePK != null ? spotpassagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spotpassage)) {
            return false;
        }
        Spotpassage other = (Spotpassage) object;
        if ((this.spotpassagePK == null && other.spotpassagePK != null) || (this.spotpassagePK != null && !this.spotpassagePK.equals(other.spotpassagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.Spotpassage[ spotpassagePK=" + spotpassagePK + " ]";
    }
    
}
