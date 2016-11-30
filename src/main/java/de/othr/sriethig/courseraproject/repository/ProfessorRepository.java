/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.repository.base.AbstractUserRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author sonja
 */
@SessionScoped
public class ProfessorRepository extends 
        AbstractUserRepository<Long, Professor> implements Serializable {
    
    public ProfessorRepository() {
        super(Professor.class);
    }
    
}
