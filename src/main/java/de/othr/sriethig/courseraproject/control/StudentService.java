/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.repository.CourseRepository;
import de.othr.sriethig.courseraproject.repository.StudentRepository;
import de.othr.sriethig.courseraproject.service.IStudentService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@RequestScoped
@NoArgsConstructor
//@WebService(endpointInterface="de.othr.sriethig.courseraproject.service.IStudentService")
public class StudentService implements Serializable, IStudentService  {
    
    @Inject
    StudentRepository studentRepository;
    
    @Inject
    CourseRepository courseRepository;
    
    @Inject
    CourseService courseService;
    
    /**
     * 
     * @param emailAddress
     * @return 
     */
    //@WebMethod(exclude = true)
    public boolean emailAlreadyInUse(String emailAddress) {
        if(studentRepository.findStudentByEmail(emailAddress) == null) {
            return false;
        } 
        return true;
    }
    
    /**
     * 
     * @param student
     * @return 
     */
    //@WebMethod(exclude = true)
    @Transactional
    public AbstractStudent registerStudent(AbstractStudent student) {
        studentRepository.persist(student);
        return student;
    }
    
    /**
     * 
     * @param student
     * @return 
     */
    // TODO
    //@WebMethod(exclude = true)
    @Transactional
    public AbstractStudent registerSNStudent(SNStudent student) {
        studentRepository.persist(student);
        return student;
    }
    
    /**
     * 
     * @param firstName
     * @param name
     * @return 
     */
    //@WebMethod(exclude = true)
    public AbstractStudent findStudentByFirstAndLastName(String firstName, 
            String name) {
        AbstractStudent student = 
                studentRepository.findStudentByFirstAndLastName(firstName, name);
        return student;
    }
    
    /**
     * 
     * @param emailAddress
     * @return 
     */
    //@WebMethod(exclude = true)
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
    //@WebMethod(exclude = true)
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
    //@WebMethod(exclude = true)
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
    //@WebMethod(exclude = true)
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
    //@WebMethod(exclude = true)
    @Transactional
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
    //@WebMethod(exclude = true)
    @Transactional
    public AbstractStudent enrollInCourse(AbstractStudent student,
            Course newCourse) {
        student = (AbstractStudent) studentRepository.merge(student);
        newCourse = (Course) courseRepository.merge(newCourse);
        
        student = student.addCourse(newCourse);
        newCourse = newCourse.addStudent(student);
        
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
    //@WebMethod(exclude = true)
    @Transactional
    public AbstractStudent unenrollFromCourse(AbstractStudent student,
            Course course) {
        student = (AbstractStudent) studentRepository.merge(student);
        course = (Course) courseRepository.merge(course);
        
        student = student.removeCourse(course);
        course = course.removeStudent(student);
        
        courseRepository.persist(course);
        studentRepository.persist(student);
        return student;
    }

    /**
     * 
     * @param SNStudent
     * @return 
     */
    @Override
    public List<SNStudent> getStudentsInTheSameCourseAs(SNStudent snStudent) {
        List<Course> courses = (List<Course>) snStudent.getCourses();
        if(courses == null || courses.isEmpty()) {
            System.err.print("StudentService::getStudentsInTheSameCourseAs"
                    + " student is not enrolled in any courses");
            return null;
        }
        
        List<SNStudent> students = new ArrayList<>();
        students.add(snStudent);
        for(Course course : courses) {
            List<AbstractStudent> abstractStudents = 
                    (List<AbstractStudent>) course.getStudents();
            for(AbstractStudent abstractStudent : abstractStudents) {
                if(abstractStudent.getClass() == SNStudent.class) {
                    if (!students.contains(abstractStudent)) {
                        students.add((SNStudent) abstractStudent);
                    }
                }
            }
        }
        
        if(students.isEmpty()) {
            return null;
        }
        return students;
    }

    /**
     * 
     * @param nickName
     * @return 
     */
    /*@Override
    public List<SNStudent> getStudentsInTheSameCourseAs(String nickName) {
        SNStudent student = (SNStudent) findStudentByEmail(nickName);
        if(student == null) {
            System.err.print("StudentService::getStudentsInTheSameCourseAs("
                    + "nickName) student not found");
            return null;
        }
        return getStudentsInTheSameCourseAs(student);
    }*/
}
