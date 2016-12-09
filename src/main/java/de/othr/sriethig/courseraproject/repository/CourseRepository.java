/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
                + "Course WHERE c.title = :parameter1");
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
        /*
        String s = "SELECT B FROM AbstractBook AS B WHERE ";
		s = s.concat(Arrays.asList(term.split(" ")).stream()
				.map(str -> "LOWER(B.name) LIKE '%" + str.toLowerCase() + "%'")
				.collect(Collectors.joining(" OR ")));

        return bookManager.createQuery(s).getResultList();
        */
        String queryString  = "SELECT c FROM Course AS c WHERE ";
        queryString = queryString.concat(Arrays.asList(tag.split(" ")).stream()
                        .map(str -> "LOWER(c.title) LIKE '%" + str.toLowerCase() + "%' OR "
                                + "LOWER(c.description) LIKE '%" + str.toLowerCase() + "%'")
                        .collect(Collectors.joining (" OR ")));
        /*TypedQuery<Course> query = this.createTypedQuery("SELECT c FROM "
                + "Course AS c WHERE c.description LIKE :parameter1 OR "
                + "c.title LIKE :parameter2"
        );
        query.setParameter("parameter1", tag);
        query.setParameter("parameter2", tag);*/
        TypedQuery<Course> query = this.createTypedQuery(queryString);
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
                + "Courses As c WHERE c.professor = :parameter1", 
                this.getType()
        );
        query.setParameter("parameter1", professor);
        List<Course> courses = query.getResultList();
        if(courses.isEmpty()) {
            return null;
        } else {
            return courses;
        }
    }
    
}
