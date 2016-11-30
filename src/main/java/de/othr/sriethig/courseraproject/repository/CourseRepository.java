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

/**
 *
 * @author sonja
 */
@SessionScoped
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
                + "Courses WHERE c.title = :1");
        query.setParameter("1", title);
        Course course = (Course) query.getSingleResult();
        return course;
    }
    
    /**
     * 
     * @param tag
     * @return 
     */
    public List<Course> findCoursesWithTag(String tag) {
        TypedQuery<Course> query = this.getEntityManager().createQuery("SELECT c FROM "
                + "Courses WHERE c.description LIKE :parametername", 
                this.getType()
        );
        query.setParameter("parametername", tag);
        List<Course> courses = query.getResultList();
        return courses;
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
        return courses;
    }
    
}
