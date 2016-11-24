/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 */
public class LessonRepository extends SingleIdEntityRepository<Long, Lesson> {
    
    public LessonRepository() {
        super(Lesson.class);
    }  
    
    /**
     * 
     * @param title
     * @return 
     */
    public Lesson findLessonByTitle(String title) {
        TypedQuery<Lesson> query = this.getEntityManager().createQuery("SELECT l FROM "
                + "Lesson WHERE l.title = :parametername", 
                this.getType()
        );
        query.setParameter("parametername", title);
        Lesson lesson = (Lesson) query.getSingleResult();
        return lesson;
    }
}
