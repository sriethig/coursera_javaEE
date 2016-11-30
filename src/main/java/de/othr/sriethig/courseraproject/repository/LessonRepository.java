/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 */
@SessionScoped
public class LessonRepository extends 
        SingleIdEntityRepository<Long, Lesson> implements Serializable {
    
    public LessonRepository() {
        super(Lesson.class);
    }  
    
    /**
     * 
     * @param title
     * @return 
     */
    public Lesson findLessonByTitle(String title) {
        TypedQuery<Lesson> query = this.createTypedQuery("SELECT l FROM "
                + "Lesson WHERE l.title = :1");
        query.setParameter("1", title);
        Lesson lesson = (Lesson) query.getSingleResult();
        return lesson;
    }
}
