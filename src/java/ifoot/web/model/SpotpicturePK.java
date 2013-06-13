/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifoot.web.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ã¨µÄÓã¶ù
 */
@Embeddable
public class SpotpicturePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "spot_id")
    private String spotId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "table")
    private String table;

    public SpotpicturePK() {
    }

    public SpotpicturePK(String spotId, String table) {
        this.spotId = spotId;
        this.table = table;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spotId != null ? spotId.hashCode() : 0);
        hash += (table != null ? table.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpotpicturePK)) {
            return false;
        }
        SpotpicturePK other = (SpotpicturePK) object;
        if ((this.spotId == null && other.spotId != null) || (this.spotId != null && !this.spotId.equals(other.spotId))) {
            return false;
        }
        if ((this.table == null && other.table != null) || (this.table != null && !this.table.equals(other.table))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.SpotpicturePK[ spotId=" + spotId + ", table=" + table + " ]";
    }
    
}
