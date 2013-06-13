/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifoot.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author Ã¨µÄÓã¶ù
 */
@Entity
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByUser", query = "SELECT m FROM Message m WHERE m.messagePK.user = :user"),
    @NamedQuery(name = "Message.findByLeaver", query = "SELECT m FROM Message m WHERE m.messagePK.leaver = :leaver"),
    @NamedQuery(name = "Message.findByTime", query = "SELECT m FROM Message m WHERE m.time = :time")})
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MessagePK messagePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "user", referencedColumnName = "user_name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;
    @JoinColumn(name = "leaver", referencedColumnName = "user_name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user2;

    public Message() {
    }

    public Message(MessagePK messagePK) {
        this.messagePK = messagePK;
    }

    public Message(MessagePK messagePK, Date time, String content) {
        this.messagePK = messagePK;
        this.time = time;
        this.content = content;
    }

    public Message(String user, String leaver) {
        this.messagePK = new MessagePK(user, leaver);
    }

    public MessagePK getMessagePK() {
        return messagePK;
    }

    public void setMessagePK(MessagePK messagePK) {
        this.messagePK = messagePK;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messagePK != null ? messagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messagePK == null && other.messagePK != null) || (this.messagePK != null && !this.messagePK.equals(other.messagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.Message[ messagePK=" + messagePK + " ]";
    }
    
}
