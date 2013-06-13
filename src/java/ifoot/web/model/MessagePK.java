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
public class MessagePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "leaver")
    private String leaver;

    public MessagePK() {
    }

    public MessagePK(String user, String leaver) {
        this.user = user;
        this.leaver = leaver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLeaver() {
        return leaver;
    }

    public void setLeaver(String leaver) {
        this.leaver = leaver;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        hash += (leaver != null ? leaver.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessagePK)) {
            return false;
        }
        MessagePK other = (MessagePK) object;
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        if ((this.leaver == null && other.leaver != null) || (this.leaver != null && !this.leaver.equals(other.leaver))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.MessagePK[ user=" + user + ", leaver=" + leaver + " ]";
    }
    
}
