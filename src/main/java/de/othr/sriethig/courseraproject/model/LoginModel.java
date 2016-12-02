/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.DummyDataService;
import de.othr.sriethig.courseraproject.control.LoginService;
import de.othr.sriethig.courseraproject.control.ProfessorService;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.SCStudent;
import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
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
    
    @Getter @Setter private String emailAddress;
    @Getter @Setter private String password;
    
    @Getter @Setter private String message;
    
    @Getter AbstractUser abstractUser;
    /*
        error message styling:
        http://blog.primefaces.org/?p=1170
    */
    
    @Getter @Setter private boolean isAuthorizedSCStudent;
    @Getter @Setter private boolean isAuthorizedSNStudent;
    @Getter @Setter private boolean isAuthorizedProfessor;
    
    @Inject
    DummyDataService dummyDataService;
    
    @Inject
    LoginService loginService;
    
    @Inject
    ProfessorService professorService;
    
    /**
     * 
     */
    public String login() {
        this.message = "";
        
        abstractUser = loginService.authenticate(
                this.emailAddress, this.password
        );
        
        if(abstractUser == null) {
            this.message = "Email and/or password wrong!\n Please try again!";
        } else if(abstractUser.getClass() == Professor.class) {
            this.isAuthorizedProfessor = true;
        } else if(abstractUser.getClass() == SCStudent.class) {
            this.isAuthorizedSCStudent = true;
            return "sc_student.xhtml";
        } else if(abstractUser.getClass() == SNStudent.class) {
            this.isAuthorizedSNStudent = true;
            return "sc_student.xhtml";
        }
        this.password = "";
        return "login.xhtml";
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
     */
    public void loginWithTestAccount() {
        this.setEmailAddress("test.prof@oth-regensburg.de");
        this.setPassword("test");
        
        login();
    }
    
    public void initialize() {
        dummyDataService.insertDummyData();
        this.emailAddress = "Max.Mustermann@st.oth-regensburg.de";
        this.password = "Max";
    }
    
}
