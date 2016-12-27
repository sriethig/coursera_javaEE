/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.StudentService;
import de.othr.sriethig.courseraproject.entity.Country;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
public class SignUpModel implements Serializable {
    
    @Getter @Setter private int tabIndex = 0;
    
    @Getter @Setter private String emailAddressSC;
    @Getter @Setter private String passwordSC;
    
    @Getter @Setter private String nickNameSN;
    @Getter @Setter private String passwordSN;
    
    @Getter @Setter private String messageSC = "";
    @Getter @Setter private String messageSN = "";
    
    @Getter @Setter private boolean personalRendered = false;
    @Getter @Setter private boolean addressRendered = false;
    @Getter @Setter private boolean confirmRendered = false;
    
    @Getter @Setter private boolean signUpSC;
    @Getter @Setter private boolean signUpSN;
    
    @Getter @Setter private String firstName;
    @Getter @Setter private String name;
    
    @Getter @Setter private String street;
    @Getter @Setter private int streetNumber;
    @Getter @Setter private long zipCode;
    @Getter @Setter private String city;
    @Getter @Setter private Country country;
    
    @Inject
    LoginModel loginModel;
    
    @Inject
    StudentService studentService;
            
    /**
     * 
     */
    @PostConstruct
    public void initialize() {
        System.out.println("SignUpModel::initialize " + loginModel.isAuthorized());
    }
    
    /**
     * 
     * @return 
     */
    public String loginInfoSC() {
        if(studentService.emailAlreadyInUse(this.emailAddressSC)) {
            this.messageSC = "Email is already in use!";
            return "sign_up";
        }
        
        this.personalRendered = true;
        this.tabIndex = 1;
        this.signUpSC = true;
        this.signUpSN = false;
        return "sign_up";
    }
    
    /**
     * 
     * @return 
     */
    public String loginInfoSN() {
        System.out.println("SignUpModel::loginInfoOK " + this.nickNameSN + ", " + this.passwordSN);
        
        this.personalRendered = true;
        this.tabIndex = 1;
        this.signUpSC = false;
        this.signUpSN = true;
        return "sign_up";
    }
    
    /**
     * 
     * @return 
     */
    public String personalInfoOK() {
        System.out.println("SignUpModel::personalInfo " + this.firstName + ", " + this.name);
        this.addressRendered = true;
        this.tabIndex = 2;
        return "sign_up";
    }
    
    public String addressInfoOK() {
        this.confirmRendered = true;
        this.tabIndex = 3;
        return "sign_up";
    }
    
    /**
     * 
     * @return 
     */
    private String finalizeSignUp() {
        if(this.signUpSC) {
            loginModel.setEmailAddress(this.emailAddressSC);
            loginModel.setPassword(this.passwordSC);
        } else {
            loginModel.setEmailAddress(this.nickNameSN);
            loginModel.setPassword(this.passwordSN);
        }
        
        return loginModel.login();
    }
    
}
