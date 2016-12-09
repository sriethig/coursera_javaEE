/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.repository.CourseRepository;
import de.othr.sriethig.courseraproject.repository.StudentRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@SessionScoped
@NoArgsConstructor
public class StudentService implements Serializable {
    
    @Inject
    StudentRepository studentRepository;
    
    @Inject
    CourseRepository courseRepository;
    
    @Inject
    CourseService courseService;
    
    /**
     * 
     * @param student
     * @return 
     */
    @Transactional
    public AbstractStudent registerStudent(AbstractStudent student) {
        studentRepository.persist(student);
        return student;
    }
    
    /**
     * 
     * @return 
     */
    // TODO
    @Transactional
    public AbstractStudent registerSNStudent() {
        return null;
    }
    
    /**
     * 
     * @param firstName
     * @param name
     * @return 
     */
    public AbstractStudent findStudentByFirstAndLastName(String firstName, 
            String name) {
        AbstractStudent student = 
                studentRepository.findStudentByFirstAndLastName(firstName, name);
        return student;
    }
    
    /**
     * 
     * @param student
     * @param firstName
     * @return 
     */
    @Transactional
    public AbstractStudent updateStudentFirstName(AbstractStudent student, 
            String firstName) {
        student = (AbstractStudent) studentRepository.merge(student);
        student.setFirstName(firstName);
        return student;
    }
    
    /**
     * 
     * @param student
     * @param name
     * @return 
     */
    @Transactional
    public AbstractStudent updateStudentName(AbstractStudent student, 
            String name) {
        student = (AbstractStudent) studentRepository.merge(student);
        student.setFirstName(name);
        return student;
    }
    
    /**
     * 
     * @param student
     * @param address
     * @return 
     */
    @Transactional
    public AbstractStudent updateStudentAddress(AbstractStudent student, 
            Address address) {
        student = (AbstractStudent) studentRepository.merge(student);
        student.setAddress(address);
        return student;
    }
    
    /**
     * 
     * @param student
     * @return 
     */
    public List<Course> getEnrolledCourses(AbstractStudent student) {
        student = (AbstractStudent) studentRepository.merge(student);
        List<Course> enrolledCourses = (List) student.getCourses();
        return enrolledCourses;
    }
    
    /**
     * 
     * @param student
     * @param newCourse
     * @return 
     */
    @Transactional
    public List<Course> enrollInCourse(AbstractStudent student,
            Course newCourse) {
        student = (AbstractStudent) studentRepository.merge(student);
        newCourse = (Course) courseRepository.merge(newCourse);
        
        List<Course> enrolledCourses = (List<Course>) student.getCourses();
        enrolledCourses.add(newCourse);
        courseRepository.getEntityManager().persist(newCourse);
        studentRepository.getEntityManager().persist(student);
        return enrolledCourses;
    }
    
    /**
     * 
     * @param student
     * @param course
     * @return 
     */
    @Transactional
    public List<Course> unenrollFromCourse(AbstractStudent student,
            Course course) {
        student = (AbstractStudent) studentRepository.merge(student);
        course = (Course) courseRepository.merge(course);
        
        List<Course> enrolledCourses = (List<Course>) student.getCourses();
        if(enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
        } else {
            //TODO ask about removing objects
        }
        return enrolledCourses;
    }
}
