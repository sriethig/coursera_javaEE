/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 */
@SessionScoped
public class ProfessorRepository extends 
        SingleIdEntityRepository<Long, Professor> implements Serializable {
    
    public ProfessorRepository() {
        super(Professor.class);
    }
    
    /**
     * 
     * @return 
     */
    public List<Professor> getAllProfessors() {
        TypedQuery<Professor> query = this.createTypedQuery("SELECT p FROM "
                + "Professor AS p");
        List<Professor> professors = query.getResultList();
        return professors;
    }
}
