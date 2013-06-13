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
public class SpotpassagePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "id_spot")
    private String idSpot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "table")
    private String table;

    public SpotpassagePK() {
    }

    public SpotpassagePK(String idSpot, String table) {
        this.idSpot = idSpot;
        this.table = table;
    }

    public String getIdSpot() {
        return idSpot;
    }

    public void setIdSpot(String idSpot) {
        this.idSpot = idSpot;
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
        hash += (idSpot != null ? idSpot.hashCode() : 0);
        hash += (table != null ? table.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpotpassagePK)) {
            return false;
        }
        SpotpassagePK other = (SpotpassagePK) object;
        if ((this.idSpot == null && other.idSpot != null) || (this.idSpot != null && !this.idSpot.equals(other.idSpot))) {
            return false;
        }
        if ((this.table == null && other.table != null) || (this.table != null && !this.table.equals(other.table))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.SpotpassagePK[ idSpot=" + idSpot + ", table=" + table + " ]";
    }
    
}
