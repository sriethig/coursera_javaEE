/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 * @param <Long>
 * @param <Professor>
 */
public class ProfessorRepository<Long, Professor> extends SingleIdEntityRepository {
    
    public ProfessorRepository(Class type) {
        super(type);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public Professor findProfessorByName(String name) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT p FROM "
                + "Professor AS p WHERE p.name = :parametername", 
                this.getType()
        ); 
        query.setParameter("parametername", name);
        Professor professor = (Professor) query.getSingleResult();
        return professor;
    }
}
