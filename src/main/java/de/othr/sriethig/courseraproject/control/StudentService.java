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
@Transactional(Transactional.TxType.REQUIRED)
public class StudentService implements Serializable {
    
    @Inject
    StudentRepository studentRepository;
    
    @Inject
    CourseRepository courseRepository;
    
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
    public AbstractStudent enrollInCourse(AbstractStudent student,
            Course newCourse) {
        student = (AbstractStudent) studentRepository.merge(student);
        newCourse = (Course) courseRepository.merge(newCourse);
        
        newCourse = newCourse.addStudent(student);
        student = student.addCourse(newCourse);
        
        courseRepository.persist(newCourse);
        studentRepository.persist(student);
        return student;
    }
    
    /**
     * 
     * @param student
     * @param course
     * @return 
     */
    public AbstractStudent unenrollFromCourse(AbstractStudent student,
            Course course) {
        student = (AbstractStudent) studentRepository.merge(student);
        course = (Course) courseRepository.merge(course);

        course = course.removeStudent(student);
        student = student.removeCourse(course);
        
        courseRepository.persist(course);
        studentRepository.persist(student);
        return student;
    }
}
