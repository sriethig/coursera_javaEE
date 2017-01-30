/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import de.othr.sriethig.courseraproject.repository.base.AbstractUserRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 * Service for all operations on the entity AbstractUser
 */
@RequestScoped
@NoArgsConstructor
public class AbstractUserService implements Serializable {
    
    @Inject
    @Getter @Setter private AbstractUserRepository abstractUserRepository;
    
    /**
     * 
     * @param id
     * @return 
     */
    public AbstractUser findById(Long id) {
        return abstractUserRepository.findById(id);
    }
    
    /**
     * 
     * @return 
     */
    public List<AbstractUser> findAll() {
        return abstractUserRepository.findAll();
    }
    
}
