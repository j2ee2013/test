/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifoot.web.control;

import ifoot.web.model.User;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author 猫的鱼儿
 */
@ManagedBean
@SessionScoped
public class logincontrol {
   /**
     * 
     */
    //@PersistenceContext(unitName="ProjectForMiddlePresentationPU")
    //EntityManager em;
    @PersistenceContext(unitName="ifootPU")
    EntityManager em;
    @Resource
    UserTransaction userTransaction;
    private User user = new User();
    private boolean loginSign=false;
    private String errorMessage="";
    private String validateCode;
    private boolean userPer = false;

    public boolean isUserPer() {
        return userPer;
    }

    public void setUserPer(boolean userPer) {
        this.userPer = userPer;
    }
    public boolean isLoginSign() {
        return loginSign;
    }

    public void setLoginSign(boolean loginSign) {
        this.loginSign = loginSign;
    }


    
    /**
     * 
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
     public String getValidateCode()
     {
        return validateCode;
    }

    public void setValidateCode(String validateCode)
    {
        this.validateCode = validateCode;
    }
    
    /**
     * Creates a new instance of asdf
     */
    public logincontrol() {
    }
    
    public String doLogin(){
        if(this.userPer)
            this.user.setUserPermission("admin");
        else
            this.user.setUserPermission("user");
        this.setErrorMessage("");
        System.out.println("name: "+this.user.getUserName()+"pwd"+this.user.getUserPwd()+"per:"+this.user.getUserPermission());

        String key = (String)( ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("key"));
         if (!key.equals(validateCode))
         {
             this.setErrorMessage("验证码错误");
            //setLoginError("验证码错误！");
            FacesMessage message = new FacesMessage(
            FacesMessage.SEVERITY_ERROR, "", "验证码错误");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "failure";
         }
        
        Query checkSql = em.createNamedQuery("User.checkUser");
        checkSql.setParameter("name", this.user.getUserName());
        checkSql.setParameter("password", this.user.getUserPwd());
        checkSql.setParameter("permission", this.user.getUserPermission());
        if(checkSql.getResultList().size() == 1){
            this.loginSign =true;
            FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginSign","true");
            return "success";
        }
        else{
            this.loginSign = false;
            System.out.print("wrong!============================");
            this.setErrorMessage("用户名或密码错误");
            return "false";
        }
    }
    
    public void doLogout(){
        System.out.println("============out=====================");
        this.loginSign = false;
    }
    
    /**
     * Message Functions
     */
    public void addMessage() {  
        
        String summary = (this.user.getUserPermission()=="admin") ? "Admin" : "user";  
  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));  
    }
    
    
    
    public void save() {  
        addMessage("Data saved");  
    }  
      
    public void update() {  
        addMessage("Data updated");  
    }  
      
    public void delete() {  
        addMessage("Data deleted");  
    }  
      
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
