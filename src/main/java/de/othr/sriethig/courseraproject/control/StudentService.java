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
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author sonja
 */
@Transactional
public class StudentService {
    
    @Inject
    StudentRepository studentRepository;
    
    @Inject
    CourseRepository courseRepository;
    
    /**
     * 
     */
    public StudentService() {   
    }
    
    /**
     * 
     * @param student
     * @return 
     */
    public AbstractStudent registerStudent(AbstractStudent student) {
        studentRepository.persist(student);
        return student;
    }
    
    /**
     * 
     * @param student
     * @return 
     */
    //TODO
    public AbstractStudent loginStudent(AbstractStudent student) {
        return null;
    }
    
    /**
     * 
     * @param student
     * @param firstName
     * @return 
     */
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
    public List<Course> showEnrolledCourses(AbstractStudent student) {
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
    public List<Course> enrollInCourse(AbstractStudent student,
            Course newCourse) {
        student = (AbstractStudent) studentRepository.merge(student);
        List<Course> enrolledCourses = (List) student.getCourses();
        enrolledCourses.add(newCourse);
        return enrolledCourses;
    }
    
    /**
     * 
     * @param student
     * @param course
     * @return 
     */
    public List<Course> unenrollFromCourse(AbstractStudent student,
            Course course) {
        student = (AbstractStudent) studentRepository.merge(student);
        course = (Course) courseRepository.merge(course);
        
        List<Course> enrolledCourses = (List) student.getCourses();
        if(enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
        } else {
            //TODO ask about removing objects
        }
        return enrolledCourses;
    }
}
