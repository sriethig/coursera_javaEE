/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.StudentService;
import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Country;
import de.othr.sriethig.courseraproject.entity.SCStudent;
import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import de.othr.sriethig.courseraproject.service.ISNUserService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Named
@SessionScoped
@NoArgsConstructor
public class SignUpModel implements Serializable {
    
    @Getter @Setter private int tabIndex = 0;
    
    @Getter @Setter private AbstractUser abstractUser;
    
    @Getter @Setter private String emailAddressSC;
    @Getter @Setter private String passwordSC;
    
    @Getter @Setter private String nickNameSN;
    @Getter @Setter private String passwordSN;
    
    @Getter @Setter private String messageSC = "";
    @Getter @Setter private String messageSN = "";
    
    @Getter @Setter private String messagePersonalInfo = "";
    @Getter @Setter private String messageAddressInfo = "";
    
    @Getter @Setter private boolean personalRendered = false;
    @Getter @Setter private boolean addressRendered = false;
    @Getter @Setter private boolean confirmRendered = false;
    
    @Getter @Setter private boolean signUpSC;
    @Getter @Setter private boolean signUpSN;
    
    @Getter @Setter private String firstName;
    @Getter @Setter private String name;
    
    @Getter @Setter private String street;
    @Getter @Setter private Integer streetNumber;
    @Getter @Setter private Long zipCode;
    @Getter @Setter private String city;
    @Getter @Setter private Country country;
    
    @Inject
    private LoginModel loginModel;
    
    @Inject
    private StudentService studentService;
    
    @Inject
    private ISNUserService SNUserService;
            
    /**
     * 
     */
    @PostConstruct
    public void initialize() {
    }
    
    /**
     * 
     * @return 
     */
    public String loginInfoSC() {
        if(this.emailAddressSC.equals("")) {
            this.messageSC = "Email address required!";
            return "sign_up";
        }
        if(this.passwordSC.equals("")) {
            this.messageSC = "Please enter a password!";
            return "sign_up";
        }
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
        if(this.nickNameSN.equals("")) {
            this.messageSC = "Please enter your Nutwork nickname!";
            return "sign_up";
        }
        if(this.passwordSN.equals("")) {
            this.messageSC = "Please enter a password!";
            return "sign_up";
        }
        
        SNStudent student = 
                SNUserService.authenticateSNUser(this.nickNameSN, this.passwordSN);
        
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
        if(this.firstName.equals("") || this.name.equals("")) {
            this.messagePersonalInfo = "Please enter your first and last name!";
            return "sign_up";            
        }
        
        this.addressRendered = true;
        this.tabIndex = 2;
        return "sign_up";
    }
    
    /**
     * 
     * @return 
     */
    public String addressInfoOK() {
        if(this.street.equals("") 
                || this.streetNumber == 0
                || this.zipCode == 0
                || this.city.equals("")) {
            this.messageAddressInfo = "Please enter your address information!";
            return "sign_up";            
        }
        
        this.confirmRendered = true;
        this.tabIndex = 3;
        return "sign_up";
    }
    
    /**
     * 
     * @return 
     */
    public String finalizeSignUp() {
        Address address = new Address(
                this.street + " " + this.streetNumber,
                this.zipCode,
                this.city,
                this.country
        );
        
        if(this.signUpSC) {
            SCStudent scStudent = new SCStudent();
            scStudent.setEmailAddress(this.emailAddressSC);
            scStudent.setPassword(this.passwordSC);
            scStudent.setFirstName(this.firstName);
            scStudent.setName(this.name);
            scStudent.setAddress(address);
            studentService.registerStudent(scStudent);
            
            loginModel.setEmailAddress(this.emailAddressSC);
            loginModel.setPassword(this.passwordSC);
        } else {
            SNStudent snStudent = new SNStudent();
            snStudent.setEmailAddress(this.emailAddressSC);
            snStudent.setPassword(this.passwordSC);
            snStudent.setFirstName(this.firstName);
            snStudent.setName(this.name);
            snStudent.setAddress(address);
            studentService.registerStudent(snStudent);
            
            loginModel.setEmailAddress(this.nickNameSN);
            loginModel.setPassword(this.passwordSN);
        }
        
        return loginModel.login();
    }
    
    /**
     * JSF built-in enum converter for the dropdown box
     * @return 
     */
    public Country[] getCountries() {
        return Country.values();
    }
    
    public String cancelSignUp() {
        this.tabIndex = 0;
        this.emailAddressSC = "";
        this.passwordSC = "";

        this.nickNameSN = "";
        this.passwordSN = "";

        this.messageSC = "";
        this.messageSN = "";

        this.messagePersonalInfo = "";
        this.messageAddressInfo = "";

        this.personalRendered = false;
        this.addressRendered = false;
        this.confirmRendered = false;

        this.signUpSC = false;
        this.signUpSN = false;

        this.firstName = "";
        this.name = "";

        this.street = "";
        this.streetNumber = 0;
        this.zipCode = Long.valueOf(0);
        this.city = "";
        return "login";
    }
    
}
