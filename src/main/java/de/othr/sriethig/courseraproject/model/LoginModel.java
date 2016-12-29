/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.AbstractUserService;
import de.othr.sriethig.courseraproject.control.DummyDataService;
import de.othr.sriethig.courseraproject.control.LoginService;
import de.othr.sriethig.courseraproject.control.ProfessorService;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.SCStudent;
import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.UserConverter;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Named
@SessionScoped
public class LoginModel implements Serializable {
    
    @Getter @Setter private List<AbstractUser> allUsers;
    
    @Getter @Setter private String emailAddress = "";
    @Getter @Setter private String password = "";
    
    @Getter @Setter private String message = "";
    
    @Getter @Setter private AbstractUser selectedUser = null;
    @Getter private AbstractUser abstractUser = null;
    /*
        error message styling:
        http://blog.primefaces.org/?p=1170
    */
    
    @Getter @Setter private boolean authorizedStudent = false;
    @Getter @Setter private boolean authorizedProfessor = false;
    private boolean authorized = false;
    
    @Inject
    private StudentModel studentModel;
    
    @Inject 
    private ProfessorModel professorModel;
    
    @Inject
    private DummyDataService dummyDataService;
    
    @Inject
    private LoginService loginService;
    
    @Inject
    private ProfessorService professorService;
    
    @Inject
    private AbstractUserService abstractUserService;
    
    @Inject
    @Getter @Setter
    private UserConverter userConverter;
    
    /**
     * 
     */
    @PostConstruct
    public void initialize() {
        //dummyDataService.insertDummyData();
        
        this.allUsers = abstractUserService.findAll();
       
        /*if(this.emailAddress.equals("")) {
            this.emailAddress = "Max.Mustermann@st.oth-regensburg.de";
        }
        if(this.password.equals("")) {
            this.password = "Max";
        }*/
    }
    
    public String userChanged(ValueChangeEvent e) {
        selectedUser = (AbstractUser) e.getNewValue();
        this.emailAddress = selectedUser.getEmailAddress();
        FacesContext.getCurrentInstance().renderResponse();
        return "login";
    }
    
    /**
     * 
     * @return 
     */
    public String login() {
        this.message = "";
                
        abstractUser = loginService.authenticate(
                this.emailAddress, this.password
        );
        
        if(abstractUser == null) {
            this.message = "Email and/or password wrong!\n Please try again!";
        } else if(abstractUser.getClass() == Professor.class) {
            this.authorizedProfessor = true;
            this.emailAddress = "";
            this.password = "";
            return "professor";
        } else if(abstractUser.getClass() == SCStudent.class) {
            this.authorizedStudent = true;
            this.emailAddress = "";
            this.password = "";
            return "student";
        } else if(abstractUser.getClass() == SNStudent.class) {
            this.authorizedStudent = true;
            this.emailAddress = "";
            this.password = "";
            return "student";
        }
        this.password = "";
        return "login";
    }
    
    public String goToProfile() {
        if(this.authorizedProfessor) {
            return "professor";
        } else if(this.authorizedStudent) {
            return "student";
        } else {
            return "login";
        }
    }
    
    /**
     * 
     * @return 
     */
    public String logout() {
        this.abstractUser = null;
        this.authorizedProfessor = false;
        this.authorizedStudent = false;
        return "login";
    }
    
    /**
     * 
     * @return 
     */
    public String register() {
        logout();
        this.authorized = false;
        return "sign_up";
    }
    
    /**
     * 
     * @return 
     */
    // TODO implement
    public String registerWithSN() {
        return "sign_up";
    }
    
    /**
     * 
     */
    // TODO insert login data for sebis network
    public void loginWithSN() {
        this.emailAddress = "";
        this.password = "";
    }
    
    /**
     * 
     * @return 
     */
    public String loginWithTestAccount() {
        this.setEmailAddress("test.prof@oth-regensburg.de");
        this.setPassword("test");
        
        return(login());
    }
    
    
    
    /**
     * 
     * @return 
     */
    public boolean isAuthorized() {
        return this.authorizedProfessor || this.authorizedStudent;
    }
    
}
