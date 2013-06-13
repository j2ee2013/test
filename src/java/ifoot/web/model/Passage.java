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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "passage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passage.findAll", query = "SELECT p FROM Passage p"),
    @NamedQuery(name = "Passage.findByPassageId", query = "SELECT p FROM Passage p WHERE p.passageId = :passageId"),
    @NamedQuery(name = "Passage.findByPassageName", query = "SELECT p FROM Passage p WHERE p.passageName = :passageName"),
    @NamedQuery(name = "Passage.findByGrade", query = "SELECT p FROM Passage p WHERE p.grade = :grade"),
    @NamedQuery(name = "Passage.findByTag1", query = "SELECT p FROM Passage p WHERE p.tag1 = :tag1"),
    @NamedQuery(name = "Passage.findByTag2", query = "SELECT p FROM Passage p WHERE p.tag2 = :tag2"),
    @NamedQuery(name = "Passage.findByTag3", query = "SELECT p FROM Passage p WHERE p.tag3 = :tag3"),
    @NamedQuery(name = "Passage.findByTest", query = "SELECT p FROM Passage p WHERE p.test = :test")})
public class Passage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "passage_id")
    private String passageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "passage_name")
    private String passageName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "grade")
    private String grade;
    @Size(max = 200)
    @Column(name = "tag1")
    private String tag1;
    @Size(max = 200)
    @Column(name = "tag2")
    private String tag2;
    @Size(max = 200)
    @Column(name = "tag3")
    private String tag3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "test")
    private int test;
    @JoinTable(name = "passagepicture", joinColumns = {
        @JoinColumn(name = "passage", referencedColumnName = "passage_id")}, inverseJoinColumns = {
        @JoinColumn(name = "picture", referencedColumnName = "picture_id")})
    @ManyToMany
    private Collection<Picture> pictureCollection;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private User userName;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPassage")
    private Spotpassage spotpassage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passage")
    private Collection<Comment> commentCollection;

    public Passage() {
    }

    public Passage(String passageId) {
        this.passageId = passageId;
    }

    public Passage(String passageId, String passageName, String content, String grade, int test) {
        this.passageId = passageId;
        this.passageName = passageName;
        this.content = content;
        this.grade = grade;
        this.test = test;
    }

    public String getPassageId() {
        return passageId;
    }

    public void setPassageId(String passageId) {
        this.passageId = passageId;
    }

    public String getPassageName() {
        return passageName;
    }

    public void setPassageName(String passageName) {
        this.passageName = passageName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    @XmlTransient
    public Collection<Picture> getPictureCollection() {
        return pictureCollection;
    }

    public void setPictureCollection(Collection<Picture> pictureCollection) {
        this.pictureCollection = pictureCollection;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public Spotpassage getSpotpassage() {
        return spotpassage;
    }

    public void setSpotpassage(Spotpassage spotpassage) {
        this.spotpassage = spotpassage;
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
        hash += (passageId != null ? passageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passage)) {
            return false;
        }
        Passage other = (Passage) object;
        if ((this.passageId == null && other.passageId != null) || (this.passageId != null && !this.passageId.equals(other.passageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.Passage[ passageId=" + passageId + " ]";
    }
    
}
