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
public class CommentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "commented_id")
    private String commentedId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "commentor_name")
    private String commentorName;

    public CommentPK() {
    }

    public CommentPK(String commentedId, String commentorName) {
        this.commentedId = commentedId;
        this.commentorName = commentorName;
    }

    public String getCommentedId() {
        return commentedId;
    }

    public void setCommentedId(String commentedId) {
        this.commentedId = commentedId;
    }

    public String getCommentorName() {
        return commentorName;
    }

    public void setCommentorName(String commentorName) {
        this.commentorName = commentorName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentedId != null ? commentedId.hashCode() : 0);
        hash += (commentorName != null ? commentorName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentPK)) {
            return false;
        }
        CommentPK other = (CommentPK) object;
        if ((this.commentedId == null && other.commentedId != null) || (this.commentedId != null && !this.commentedId.equals(other.commentedId))) {
            return false;
        }
        if ((this.commentorName == null && other.commentorName != null) || (this.commentorName != null && !this.commentorName.equals(other.commentorName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifoot.web.model.CommentPK[ commentedId=" + commentedId + ", commentorName=" + commentorName + " ]";
    }
    
}
