/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import de.othr.sriethig.courseraproject.repository.StudentRepository;
import de.othr.sriethig.courseraproject.repository.base.AbstractUserRepository;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@NoArgsConstructor
@SessionScoped
public class LoginService implements Serializable {
    
    @Inject
    AbstractUserRepository abstractUserRepository;
    
    @Inject
    StudentRepository studentRepository;
    
    @Inject
    private Logger logger;
    
    /**
     * check, if combination of email and password is valid
     * @param emailAddress
     * @param password
     * @return 
     */
    @Transactional
    public AbstractUser authenticate(String emailAddress, String password) {
        AbstractUser abstractUser = abstractUserRepository.authenticateAbstractUser(
                    emailAddress, password
            );
        if(abstractUser == null) {
            logger.log(Level.SEVERE, "LoginService::authenticate "
                    + "authentication failed");
        }
        logger.log(Level.INFO, "LoginService::authenticate successfull");
        return abstractUser;
    }
    
}
