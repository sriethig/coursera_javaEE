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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 * Service for all operations on the SNStudents and SCStudents
 */
@RequestScoped
@NoArgsConstructor
public class StudentService implements Serializable  {
    
    @Inject
    private StudentRepository studentRepository;
    
    @Inject
    private CourseRepository courseRepository;
    
    @Inject
    private CourseService courseService;
    
    @Inject
    private Logger logger;
    
    /**
     * Checks, if there already is an account with this email
     * @param emailAddress
     * @return 
     */
    public boolean emailAlreadyInUse(String emailAddress) {
        if(studentRepository.findStudentByEmail(emailAddress) == null) {
            logger.log(Level.WARNING, "StudentService::emailAlreadyInUse {0}", emailAddress);
            return false;
        } 
        return true;
    }
    
    /**
     * persists an AbstractStudent object
     * @param student
     * @return 
     */
    @Transactional
    public AbstractStudent registerStudent(AbstractStudent student) {
        studentRepository.persist(student);
        logger.log(Level.INFO, "StudentService::registerStudent {0}", student.getEmailAddress());
        return student;
    }
    
    /**
     * find student by personal information
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
     * find AbstractStudent by email
     * @param emailAddress
     * @return 
     */
    public AbstractStudent findStudentByEmail(String emailAddress) {
        AbstractStudent student = 
                studentRepository.findStudentByEmail(emailAddress);
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
     * get a list of all courses the AbstractStudent is enrolled in
     * @param student
     * @return 
     */
    @Transactional
    public List<Course> getEnrolledCourses(AbstractStudent student) {
        student = (AbstractStudent) studentRepository.merge(student);
        List<Course> enrolledCourses = (List) student.getCourses();
        return enrolledCourses;
    }
    
    /**
     * connect an object of AbstractStudent with an object of Course
     * @param student
     * @param newCourse
     * @return 
     */
    @Transactional
    public AbstractStudent enrollInCourse(AbstractStudent student,
            Course newCourse) {
        student = (AbstractStudent) studentRepository.merge(student);
        newCourse = (Course) courseRepository.merge(newCourse);
        
        student = student.addCourse(newCourse);
        newCourse = newCourse.addStudent(student);
        return student;
    }
    
    /**
     * disconnect an object of entity AbstractStudent from
     * a specified object of Course
     * @param student
     * @param course
     * @return 
     */
    @Transactional
    public AbstractStudent unenrollFromCourse(AbstractStudent student,
            Course course) {
        student = (AbstractStudent) studentRepository.merge(student);
        course = (Course) courseRepository.merge(course);
        
        student = student.removeCourse(course);
        course = course.removeStudent(student);
        return student;
    }

}
