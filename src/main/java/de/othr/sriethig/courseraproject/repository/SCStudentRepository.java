/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.SCStudent;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@SessionScoped
@Transactional
public class SCStudentRepository extends 
        SingleIdEntityRepository<Long, SCStudent> implements Serializable {

    public SCStudentRepository() { //Class<SCStudent> type
        super(SCStudent.class);
    }
    
    /**
     * 
     * @param emailAddress
     * @param password
     * @return 
     */
    public SCStudent authenticateStudent(String emailAddress, String password) {
        TypedQuery<SCStudent> query = this.getEntityManager().createQuery(
                "SELECT s FROM SCStudent WHERE s.emailAddress = :parameter1 "
                        + "AND s.password = :parameter2",
                this.getType()
        );
        query.setParameter("parameter1", emailAddress);
        query.setParameter("parameter2", password);
        
        SCStudent scStudent = query.getSingleResult();
        return scStudent;
    }
    
}
