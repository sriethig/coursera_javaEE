/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository.base;

import de.othr.sriethig.courseraproject.entity.Country;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author sonja
 */
@SessionScoped
@Transactional
public abstract class AbstractStudentRepository extends 
        AbstractUserRepository<Long, AbstractStudent> implements Serializable {
    
    public AbstractStudentRepository() {
        super(AbstractStudent.class);
    }
    
    /**
     * 
     * @param country
     * @return 
     */
    //TODO: resolve country
    public List<AbstractStudent> findStudentByCountry(Country country) {
        TypedQuery<AbstractStudent> query = this.getEntityManager().createQuery("SELECT s FROM "
            + "Student AS s WHERE s.country = :paramertername",
            this.getType()    
        );
        query.setParameter("parametername", country);
        List<AbstractStudent> students = query.getResultList();
        return students;
    }
}
