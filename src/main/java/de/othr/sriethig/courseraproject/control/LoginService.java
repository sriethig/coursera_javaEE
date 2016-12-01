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
@Transactional(Transactional.TxType.REQUIRED)
public class LoginService implements Serializable {
    
    @Inject
    AbstractUserRepository abstractUserRepository;
    
    @Inject
    StudentRepository studentRepository;
    
    /**
     * 
     * @param emailAddress
     * @param password
     * @return 
     */
    public AbstractUser authenticate(String emailAddress, String password) {
        AbstractUser abstractUser = abstractUserRepository.authenticateAbstractUser(
                        emailAddress, password
                );
        System.out.println("after authenticate: " + abstractUser.toString());
        return abstractUser;
    }
    
}
