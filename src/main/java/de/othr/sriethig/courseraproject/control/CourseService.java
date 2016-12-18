/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.repository.CourseRepository;
import de.othr.sriethig.courseraproject.repository.LessonRepository;
import de.othr.sriethig.courseraproject.repository.ProfessorRepository;
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
public class CourseService implements Serializable {
    
    @Inject
    CourseRepository courseRepository;
    
    @Inject
    ProfessorRepository professorRepository;
    
    @Inject
    StudentRepository studentRepository;

    @Inject
    LessonRepository lessonRepository;
    
    /**
     * 
     * @param course
     * @return 
     */
    public Course createCourse(Course course) {
        courseRepository.persist(course);
        return course;
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public Course findCourseByTitle(String title) {
        Course course = (Course) courseRepository.findCourseByTitle(title);
        return course;
    }
    
    /**
     * 
     * use case: user is looking for a list of courses addressing a field of
     * interest, which is specified by a keyword (e.g. 'data science)
     * solution: query all course descriptions for the tag
     * @param tag
     * @return 
     */
    public List<Course> findCoursesByTag(String tag) {
        List<Course> courses = (List) courseRepository.findCoursesWithTag(tag);
        return courses;
    }
    
    /**
     * 
     * @param course
     * @param title
     * @return 
     */
    public Course updateCourseTitle(Course course, String title) {
        course = (Course) courseRepository.merge(course);
        course.setTitle(title);
        return course;
    }
    
    /**
     * 
     * @param course
     * @param description
     * @return 
     */
    public Course updateCourseDescription(Course course, 
            String description) {
        course = (Course) courseRepository.merge(course);
        course.setDescription(description);
        return course;
    }
    
    /**
     * 
     * @param course
     * @param professor
     * @return 
     */
    public Course updateProfessor(Course course, Professor professor) {
        course = (Course) courseRepository.merge(course);
        professor = (Professor) professorRepository.merge(professor);
        
        course.setProfessor(professor);
        return course;
    }
    
    /**
     * 
     * @param course
     * @return 
     */
    public List<AbstractStudent> getStudents(Course course) {
        course = (Course) courseRepository.merge(course);
        List<AbstractStudent> students = (List) course.getStudents();
        return students;
    }
    
    /**
     * 
     * @param course
     * @param student
     * @return 
     */
    public Course addStudent(Course course,
            AbstractStudent student) {
        course = (Course) courseRepository.merge(course);
        student = (AbstractStudent) studentRepository.merge(student);
        
        course = course.addStudent(student);
        student = student.addCourse(course);
        
        studentRepository.persist(student);
        courseRepository.persist(course); // TODO not needed?!
        return course;
    }
    
    /**
     * 
     * @param course
     * @param student
     * @return 
     */
    public Course removeStudent(Course course,
            AbstractStudent student) {
        course = (Course) courseRepository.merge(course);
        student = (AbstractStudent) studentRepository.merge(student);
        
        course = course.removeStudent(student);
        student = student.removeCourse(course);
              
        studentRepository.persist(student);
        courseRepository.persist(course); // not needed?!
        return course;
    }
    
    /**
     * 
     * @param course 
     */
    public void removeCourse(Course course) {
        course = (Course) courseRepository.merge(course);
        courseRepository.remove(course);
    }
}
