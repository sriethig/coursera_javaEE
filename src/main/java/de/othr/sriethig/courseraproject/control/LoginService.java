/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.repository.SCStudentRepository;
import de.othr.sriethig.courseraproject.repository.base.AbstractUserRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@NoArgsConstructor
@SessionScoped
public class LoginService implements Serializable {
    
    @Inject
    SCStudentRepository scStudentRepository;
    
    /**
     * 
     * @param emailAddress
     * @param password
     * @return 
     */
    public boolean authenticateStudent(String emailAddress, String password) {
        
           return true;
    }
    
}
