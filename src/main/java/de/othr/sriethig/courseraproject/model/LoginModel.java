/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.LoginService;
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
    
    @Getter @Setter private boolean isAuthorizedSCStudent;
    @Getter @Setter private boolean isAuthorizedSNStudent;
    @Getter @Setter private boolean isAuthorizedProfessor;
    
    @Inject
    LoginService loginService;
    
    public void loginSCStudent() {
        
    }
    
    public void loginSNStudent() {
        
    }
    
    public void loginProfessor() {
        
    }
    
    public void loginWithTestAccount() {
        this.setEmailAddress("test@test.com");
        this.setPassword("test123!");
        
        this.isAuthorizedSCStudent =
                loginService.authenticateStudent(emailAddress, password);
        System.out.println("Email: " + this.emailAddress + " , Password: " 
                + this.password);
        System.out.println("Authentication: " + this.isAuthorizedSCStudent);
        this.emailAddress = "";
        this.password = "";
    }
    
}
