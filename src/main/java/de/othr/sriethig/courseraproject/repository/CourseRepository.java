/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
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
public class CourseRepository extends 
        SingleIdEntityRepository<Long, Course> implements Serializable {
    
    public CourseRepository() {
        super(Course.class);
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public Course findCourseByTitle(String title) {
        TypedQuery<Course> query = this.createTypedQuery("SELECT c FROM "
                + "Courses WHERE c.title = :parameter1");
        query.setParameter("parameter1", title);
        List<Course> courses = query.getResultList();        
        if(courses.isEmpty()) {
            return null;
        } else {
            return courses.get(0);
        }
    }
    
    /**
     * 
     * @param tag
     * @return 
     */
    public List<Course> findCoursesWithTag(String tag) {
        TypedQuery<Course> query = this.getEntityManager().createQuery("SELECT c FROM "
                + "Courses WHERE c.description LIKE :parametername OR "
                + "c.title LIKE :parametername", 
                this.getType()
        );
        query.setParameter("parametername", tag);
        List<Course> courses = query.getResultList();
        if(courses.isEmpty()) {
            return null;
        } else {
            return courses;
        }
    }
    
    /**
     * 
     * @param professor
     * @return 
     */
    public List<Course> findCoursesFromProfessor(String professor) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT c FROM "
                + "Courses WHERE c.professor = :parametername", 
                this.getType()
        );
        query.setParameter("parametername", professor);
        List<Course> courses = query.getResultList();
        if(courses.isEmpty()) {
            return null;
        } else {
            return courses;
        }
    }
    
}
