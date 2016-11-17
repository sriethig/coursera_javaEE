package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author sonja
 */
@Entity
public class SCStudent extends AbstractStudent {
    
    private String emailAddress;
    private String password;

    /**
     * 
     * @return 
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    
    /**
     * 
     * @param emailAddress 
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    /**
     * 
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}