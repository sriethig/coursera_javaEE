/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 * @param <Long>
 * @param <Course>
 */
public class CourseRepository<Long, Course> extends SingleIdEntityRepository {
    
    public CourseRepository(Class type) {
        super(type);
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
