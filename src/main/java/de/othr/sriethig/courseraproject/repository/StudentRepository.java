/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Country;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
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
public class StudentRepository extends 
        SingleIdEntityRepository<Long, AbstractStudent> implements Serializable {
    
    public StudentRepository() {
        super(AbstractStudent.class);
    }
    
    /**
     * 
     * @param emailAddress
     * @return 
     */
    public AbstractStudent findStudentByEmail(String emailAddress) {
        TypedQuery<AbstractStudent> query = this.createTypedQuery(
            "SELECT s From AbstractStudent s WHERE s.emailAddress = "
                    + ":parameter1" 
        );
        query.setParameter("parameter1", emailAddress);
        List<AbstractStudent> abstractStudents = query.getResultList();
        if(abstractStudents.isEmpty()) {
            return null;
        } else {
            AbstractStudent abstractStudent = abstractStudents.get(0);
            return abstractStudent;
        }
    }
    
    /**
     * 
     * @param firstName
     * @param name
     * @return 
     */
    public AbstractStudent findStudentByFirstAndLastName(String firstName, 
            String name) {
        TypedQuery<AbstractStudent> query = this.createTypedQuery(
            "SELECT s FROM AbstractStudent s WHERE s.firstName = "
                    + ":parameter1 AND s.name = :parameter2"
        );
        query.setParameter("parameter1", firstName);
        query.setParameter("parameter2", name);
        List<AbstractStudent> abstractStudents = query.getResultList();
        if(abstractStudents.isEmpty()) {
            return null;
        } else {
            AbstractStudent abstractStudent = abstractStudents.get(0);
            return abstractStudent;
        }   
    }
    
    /**
     * 
     * @param country
     * @return 
     */
    //TODO: resolve country
    public List<AbstractStudent> findStudentByCountry(Country country) {
        TypedQuery<AbstractStudent> query = this.getEntityManager().createQuery("SELECT s FROM "
            + "AbstractStudent AS s WHERE s.country = :paramertername",
            this.getType()    
        );
        query.setParameter("parametername", country);
        List<AbstractStudent> students = query.getResultList();
        return students;
    }
}
