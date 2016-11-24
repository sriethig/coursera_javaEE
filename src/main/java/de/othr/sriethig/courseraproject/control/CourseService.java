/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.repository.CourseRepository;
import de.othr.sriethig.courseraproject.repository.LessonRepository;
import de.othr.sriethig.courseraproject.repository.ProfessorRepository;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author sonja
 */
@Transactional
public class CourseService {
    
    @Inject
    CourseRepository courseRepository;
    
    @Inject
    ProfessorRepository professorRepository;

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
     * @param courseTitle
     * @return 
     */
    public Course updateCourseTitle(Course course, String courseTitle) {
        course = (Course) courseRepository.merge(course);
        course.setCourseTitle(courseTitle);
        return course;
    }
    
    /**
     * 
     * @param course
     * @param courseDescription
     * @return 
     */
    public Course updateCourseDescription(Course course, 
            String courseDescription) {
        course = (Course) courseRepository.merge(course);
        course.setCourseTitle(courseDescription);
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
    public List<AbstractStudent> addStudent(Course course,
            AbstractStudent student) {
        course = (Course) courseRepository.merge(course);
        List<AbstractStudent> students = (List) course.getStudents();
        if(!students.contains(student)) {
            students.add(student);
        }
        return students;
    }
    
    /**
     * 
     * @param course
     * @param student
     * @return 
     */
    public List<AbstractStudent> removeStudent(Course course,
            AbstractStudent student) {
        course = (Course) courseRepository.merge(course);
        List<AbstractStudent> students = (List) course.getStudents();
        if(students.contains(student)) {
            students.remove(student);
        }
        return students;
    } 
    
    /**
     * 
     * @param course
     * @param lesson
     * @return 
     */
    public List<Lesson> addLesson(Course course, Lesson lesson) {
        course = (Course) courseRepository.merge(course);
        lesson = (Lesson) lessonRepository.merge(lesson);
        
        List<Lesson> lessons = (List) course.getLessons();
        if(!lessons.contains(lesson)) {
            lessons.add(lesson);
        }
        return lessons;
    }
    
    /**
     * 
     * @param course
     * @param lesson
     * @return 
     */
    public List<Lesson> removeLesson(Course course, Lesson lesson) {
        course = (Course) courseRepository.merge(course);
        lesson = (Lesson) lessonRepository.merge(lesson);
        
        List<Lesson> lessons = (List) course.getLessons();
        if(lessons.contains(lesson)) {
            lessons.remove(lesson);
        } else {
            //TODO ask about removing non-existent objects
        }
        return lessons;
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
