/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.LoginService;
import de.othr.sriethig.courseraproject.control.ProfessorService;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.SCStudent;
import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
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
    
    @Getter @Setter private boolean isAuthorizedSCStudent;
    @Getter @Setter private boolean isAuthorizedSNStudent;
    @Getter @Setter private boolean isAuthorizedProfessor;
    
    @Inject
    LoginService loginService;
    
    @Inject
    ProfessorService professorService;
    
    /**
     * 
     */
    public void testAllProfessors() {
        List<Professor> professors = professorService.getProfessors();
        for(Professor p : professors) {
            System.out.println("Prof: " + p.getEmailAddress());
        }
    }
    
    /**
     * 
     */
    public void login() {
        this.message = "";
        AbstractUser abstractUser = loginService.authenticate(
                emailAddress, password
        );
        System.out.println("after authenticate: " + abstractUser.toString());
        if(abstractUser.getClass() == Professor.class) {
            this.message = "authenticated professor";
        } else if(abstractUser.getClass() == SCStudent.class) {
            this.message = "authenticated student";
        } else if(abstractUser.getClass() == SNStudent.class) {
            this.message = "authenticated student from SN";
        } else {
            this.message = "Email and/or password wrong!\n Please try again!";
        }
        this.password = "";
        System.out.println("message: " + this.message);
    }
    
    public void loginWithTestAccount() {
        this.setEmailAddress("test@test.com");
        this.setPassword("test123!");
        
        
        this.emailAddress = "";
        this.password = "";
    }
    
}
