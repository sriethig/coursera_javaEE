/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.BookProxy;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.repository.CourseRepository;
import de.othr.sriethig.courseraproject.repository.LessonRepository;
import de.othr.sriethig.courseraproject.repository.ProfessorRepository;
import de.othr.sriethig.courseraproject.repository.StudentRepository;
import de.othr.sriethig.courseraproject.service.IBookService;
import de.othr.sriethig.courseraproject.util.BookServiceProductiveAnnotation;
import de.othr.sriethig.courseraproject.util.BookServiceTestAnnotation;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 * Service for all operations on the entity Course
 */
@SessionScoped
@NoArgsConstructor
public class CourseService implements Serializable {
    
    @Inject
    private CourseRepository courseRepository;
    
    @Inject
    private ProfessorRepository professorRepository;
    
    @Inject
    private StudentRepository studentRepository;

    @Inject
    private LessonRepository lessonRepository;
    
    @Inject @BookServiceProductiveAnnotation //@BookServiceTestAnnotation
    private IBookService bookService;
    
    @Inject
    private Logger logger;
        
    /**
     * 
     * @param course
     * @return 
     */
    @Transactional
    public Course createCourse(Course course) {
        courseRepository.persist(course);
        return course;
    }
    
    /**
     * 
     * @return 
     */
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
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
     * interest, which is specified by a keyword (e.g. 'data science')
     * solution: query all course descriptions and titles for the tag
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
     * @param professor 
     * @return  
     */
    @Transactional
    public Course addProfessor(Course course, Professor professor) {
        course = (Course) courseRepository.merge(course);
        professor = (Professor) professorRepository.merge(professor);
        
        course = course.addProfessor(professor);
        return course;
    }
    
    /**
     * 
     * @param course
     * @param student 
     * @return  
     */
    @Transactional
    public Course addStudent(Course course,
            AbstractStudent student) {
        course = (Course) courseRepository.merge(course);
        student = (AbstractStudent) studentRepository.merge(student);
        
        course = course.addStudent(student);
        student = student.addCourse(course);
        return course;
    }
    
    /**
     * 
     * @param course
     * @param student
     * @return 
     */
    @Transactional
    public Course removeStudent(Course course,
            AbstractStudent student) {
        course = (Course) courseRepository.merge(course);
        student = (AbstractStudent) studentRepository.merge(student);
        
        course = course.removeStudent(student);
        student = student.removeCourse(course);
        return course;
    } 
    
    /**
     * 
     * @param course
     * @param lesson
     * @return 
     */
    @Transactional
    public Course addLesson(Course course, Lesson lesson) {
        course = courseRepository.merge(course);
        lesson = lessonRepository.merge(lesson);
        
        lesson = lesson.addCourse(course);
        return course;
    }
    
    /**
     * 
     * @param course
     * @param lesson
     * @return 
     */
    @Transactional
    public List<Lesson> removeLesson(Course course, Lesson lesson) {
        course = (Course) courseRepository.merge(course);
        lesson = (Lesson) lessonRepository.merge(lesson);
        
        List<Lesson> lessons = (List) course.getLessons();
        if(lessons.contains(lesson)) {
            lessons.remove(lesson);
        }
        return lessons;
    }
    
    /**
     * 
     * @param course
     * @return 
     */
    @Transactional
    public List<Lesson> getLessons(Course course) {
        course = courseRepository.merge(course);
        return (List) course.getLessons();
    }
    
    /**
     * 
     * @param course  
     */
    @Transactional
    public void removeCourse(Course course) {
        course = (Course) courseRepository.merge(course);
        
        // remove course from professors list of courses
        Professor professor = course.getProfessor();
        professor = (Professor) professorRepository.merge(professor);       
        professor = professor.removeCourse(course);
        
        // remove course from all students list of courses
        List<AbstractStudent> students = 
                (List<AbstractStudent>) course.getStudents();
        for(AbstractStudent student : students) {
            student = (AbstractStudent) studentRepository.merge(student);
            student = student.removeCourse(course);
        }
        
        // finally delete course from database
        courseRepository.remove(course);
    }
    
    /**
     * use component BookServiceService from BookStore
     * (project by Florian Fusseder) to search for book
     * recommendations for a course
     * @param tag
     * @return 
     */
    public List<BookProxy> getBooksForCourse(String tag) {
        logger.log(Level.WARNING, "CourseService::getBooksForCourse");
        return bookService.getBooksForCourse(tag);
    }
}
