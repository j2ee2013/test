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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserPwd", query = "SELECT u FROM User u WHERE u.userPwd = :userPwd"),
    @NamedQuery(name = "User.findByUserPermission", query = "SELECT u FROM User u WHERE u.userPermission = :userPermission")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_pwd")
    private String userPwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "user_permission")
    private String userPermission;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private Collection<Message> messageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user2")
    private Collection<Message> messageCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<Passage> passageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Watchfriend> watchfriendCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private Collection<Watchfriend> watchfriendCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Comment> commentCollection;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String userPwd, String userPermission) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPermission = userPermission;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection1() {
        return messageCollection1;
    }

    public void setMessageCollection1(Collection<Message> messageCollection1) {
        this.messageCollection1 = messageCollection1;
    }

    @XmlTransient
    public Collection<Passage> getPassageCollection() {
        return passageCollection;
    }

    public void setPassageCollection(Collection<Passage> passageCollection) {
        this.passageCollection = passageCollection;
    }

    @XmlTransient
    public Collection<Watchfriend> getWatchfriendCollection() {
        return watchfriendCollection;
    }

    public void setWatchfriendCollection(Collection<Watchfriend> watchfriendCollection) {
        this.watchfriendCollection = watchfriendCollection;
    }

    @XmlTransient
    public Collection<Watchfriend> getWatchfriendCollection1() {
        return watchfriendCollection1;
    }

    public void setWatchfriendCollection1(Collection<Watchfriend> watchfriendCollection1) {
        this.watchfriendCollection1 = watchfriendCollection1;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.User[ userName=" + userName + " ]";
    }
    
}
