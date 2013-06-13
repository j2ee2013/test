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
public class WatchfriendPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "watch_name")
    private String watchName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "watched_name")
    private String watchedName;

    public WatchfriendPK() {
    }

    public WatchfriendPK(String watchName, String watchedName) {
        this.watchName = watchName;
        this.watchedName = watchedName;
    }

    public String getWatchName() {
        return watchName;
    }

    public void setWatchName(String watchName) {
        this.watchName = watchName;
    }

    public String getWatchedName() {
        return watchedName;
    }

    public void setWatchedName(String watchedName) {
        this.watchedName = watchedName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (watchName != null ? watchName.hashCode() : 0);
        hash += (watchedName != null ? watchedName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WatchfriendPK)) {
            return false;
        }
        WatchfriendPK other = (WatchfriendPK) object;
        if ((this.watchName == null && other.watchName != null) || (this.watchName != null && !this.watchName.equals(other.watchName))) {
            return false;
        }
        if ((this.watchedName == null && other.watchedName != null) || (this.watchedName != null && !this.watchedName.equals(other.watchedName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.WatchfriendPK[ watchName=" + watchName + ", watchedName=" + watchedName + " ]";
    }
    
}
