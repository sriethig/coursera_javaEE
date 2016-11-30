/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 */
@SessionScoped
public class ExamRepository extends 
        SingleIdEntityRepository<Long, Exam> implements Serializable {
    
    public ExamRepository() {
        super(Exam.class);
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public Exam findExamByTitle(String title) {
        TypedQuery<Exam> query = this.getEntityManager().createQuery("SELECT e FROM "
                + "Exam WHERE e.title = :parametername", 
                this.getType()
        );
        query.setParameter("parametername", title);
        Exam exam = (Exam) query.getSingleResult();
        return exam;
    }
    
}
