/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifoot.web.control;

import ifoot.web.model.User;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author 猫的鱼儿
 */
@ManagedBean
@RequestScoped
public class registrationControl {

    @PersistenceContext(unitName = "ifootPU")
    EntityManager em;
    @Resource
    UserTransaction userTransaction;
    private User user = new User();
    private List<User> userList = new ArrayList<User>();
    private String nameAvaliable;
    private String validateCode;

    public String getNameAvaliable() {
        if (this.user.getUserName() == null) {
            this.nameAvaliable = "用户名不能为空！";
        } else {
            Query nameQuery = em.createNamedQuery("User.findByUserName");
            nameQuery.setParameter("userName", this.user.getUserName());
            if (nameQuery.getResultList().size() != 0) {
                this.nameAvaliable = "用户名已被注册！";
            } else {
                this.nameAvaliable = "用户名可用";
            }
        }
        return this.nameAvaliable;
    }

    public void setNameAvaliable(String nameAvaliable) {
        this.nameAvaliable = nameAvaliable;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Creates a new instance of registrationControl
     */
    public registrationControl() {
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String doRegister() {
        System.out.println("doing--------");
        String key = (String)( ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("key"));
         if (!key.equals(validateCode))
         {
            //setLoginError("验证码错误！");
            FacesMessage message = new FacesMessage(
            FacesMessage.SEVERITY_ERROR, "", "验证码错误");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "failure";
         }
        if ((!(this.getNameAvaliable() == "用户名可用")) && (this.user.getUserName() == null || this.user.getUserPwd() == null || this.user.getUserPwd() == null)) {
            return "faile";
        }
        if (this.user.getUserPermission() == "true") {
            this.user.setUserPermission("admin");
        } else if (this.user.getUserPermission() == "false") {
            this.user.setUserPermission("user");
        }
        this.user.setUserPermission("user");
        this.user.setUserPicture("resources/default.png");
        this.user.setUserScore("0");
        
        System.out.println("===================================");
        System.out.println("name: "+this.user.getUserName()+"; pwd: "+this.user.getUserPwd()+"; per: "+this.user.getUserPermission()
                +"; sex: "+this.user.getUserSex()+"; email: "+this.user.getUserEmail()+"; pic: "+this.user.getUserPicture());
        try {
            userTransaction.begin();

            em.persist(this.user);

            userTransaction.commit();

        } catch (NotSupportedException ex) {
            Logger.getLogger(registrationControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(registrationControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(registrationControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(registrationControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(registrationControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(registrationControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(registrationControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.getNameAvaliable() == "用户名已被注册！") {
            this.userList = this.getAllUsers();
            return "success";
        } else {
            return "faile";
        }
    }

    public List<User> getAllUsers() {
        List<User> users;
        Query squery = em.createNamedQuery("User.findAll");
        users = (List<User>) squery.getResultList();
        return users;
    }

    /**
     * message
     */
    public void addMessage() {
        if (this.user.getUserPermission() == "true") {
            this.user.setUserPermission("admin");
        } else if (this.user.getUserPermission() == "false") {
            this.user.setUserPermission("user");
        }
        String summary = "You have choosed as a" + this.user.getUserPermission();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void upload(FileUploadEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        InputStream in = event.getFile().getInputstream();
        byte[] buffer = new byte[1024 * 1024 * 3];
        javax.servlet.ServletContext sc = (javax.servlet.ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String trace = sc.getRealPath("/") + "/resources/" + this.user.getUserName()+".png";
        this.user.setUserPicture("resources/"+this.user.getUserName()+".png");
        
        FileOutputStream fileOutputStream =
                new FileOutputStream(trace);    //上传的文件写服务器目录
        while (in.read(buffer) > 0) {
            fileOutputStream.write(buffer);
        }
        in.close();
        fileOutputStream.close();
    }

}
