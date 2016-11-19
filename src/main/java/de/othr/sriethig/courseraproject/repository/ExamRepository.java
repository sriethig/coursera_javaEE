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
 * @param <Exam>
 */
public class ExamRepository<Long, Exam> extends SingleIdEntityRepository {
    
    public ExamRepository(Class type) {
        super(type);
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public Exam findExamByTitle(String title) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT e FROM "
                + "Exam WHERE e.title = :parametername", 
                this.getType()
        );
        query.setParameter("parametername", title);
        Exam exam = (Exam) query.getSingleResult();
        return exam;
    }
    
}
