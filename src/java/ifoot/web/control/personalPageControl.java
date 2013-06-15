/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifoot.web.control;

import ifoot.web.model.User;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ã¨µÄÓã¶ù
 */
@ManagedBean
@RequestScoped
public class personalPageControl {

    @PersistenceContext(unitName = "ifootPU")
    EntityManager em;
    @Resource
    UserTransaction userTransaction;
    private String userName = "guest";
    private User user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        if(this.userName != "guest")
        {
            Query query = em.createNamedQuery("User.findByUserName");
            query.setParameter("userName", this.userName);
            List<User> res = query.getResultList();
            if(res.size() == 1){
                this.user = res.get(0);
            }
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Creates a new instance of personalPageControl
     */
    public personalPageControl() {
    }
}
