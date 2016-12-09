/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.CourseService;
import de.othr.sriethig.courseraproject.control.LessonService;
import de.othr.sriethig.courseraproject.control.VideoService;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.Video;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Named
@SessionScoped
public class CourseModel implements Serializable {
    
    @Getter @Setter private Course course;
    @Getter @Setter private String title;
    @Getter @Setter private String description;
    @Getter @Setter private List<Lesson> lessons;
    
    @Getter @Setter private String lessonTitle;
    @Getter @Setter private String lessonContent;
    @Getter @Setter private String lessonVideoTitle;
    @Getter @Setter private String lessonVideoDescription;
    @Getter @Setter private String lessonVideoURL;
    
    @Inject
    private LoginModel loginModel;
    
    @Inject
    private StudentModel studentModel;
    
    @Inject
    private CourseService courseService;
    
    @Inject
    private LessonService lessonService;
    
    @Inject
    private VideoService videoService;
    
    /**
     * 
     */
    public void initialize() {
        title = this.course.getTitle();
        description = this.course.getDescription();
        lessons = (List<Lesson>) this.course.getLessons();
        // get books from flo's amazon
        /*
         <!-- list of books recommended for this course -->
        <div style="height: 15px"/>
        <b:dataTable value="#{courseModel.books}" var="book" 
                     rendered="#{!courseModel.enableEnrollInThisCourse()}">

        </b:dataTable>
        <!-- /list of books -->
        */
    }
    
    /**
     * 
     * @param course
     * @return 
     */
    public String showCourse(Course course) {
        this.course = course;
        return "show_course.xhtml";
    }
    
    /**
     * 
     * @param course
     * @return 
     */
    @Transactional
    public String editCourse(Course course) {
        this.course = course;
        return "edit_course.xhtml";
    }
    
    /**
     * 
     */
    @Transactional
    public void enrollInThisCourse() {
        studentModel.enrollInCourse(course);
    }
    
    /**
     * 
     */
    @Transactional
    public void updateCourse() {
        System.out.println("updating course");
        course = courseService.updateCourseTitle(this.course, this.title);
        course = courseService.updateCourseDescription(this.course, this.description);
    }
    
    /**
     * 
     */
    @Transactional
    public void addLesson() {
        Lesson lesson = new Lesson();
        lesson.setTitle(this.lessonTitle);
        lesson.setLessonContent(this.lessonContent);
        
        Video video = new Video();
        video.setTitle(this.lessonVideoTitle);
        video.setDescription(this.lessonVideoDescription);
        video.setUrl(this.getLessonVideoURL());
        
        lessonService.createLesson(lesson);
        videoService.createVideo(video);
        lesson = lessonService.addVideo(lesson, video);
    }
    
    /**
     * 
     * @return 
     */
    public String goBack() {
        studentModel.setDetailCourse(null);
        if(loginModel.isAuthorizedProfessor()) {
            return "professor.xhtml";
        } else if(loginModel.isAuthorizedSCStudent() || loginModel.isAuthorizedSNStudent()) {
            return "student.xhtml";
        } else {
            return "login.xhtml";
        }
    }
    
    /**
     * 
     * @return 
     */
    public boolean enableEnrollInThisCourse() {
        if(loginModel.isAuthorizedProfessor()) {
            return false;
        } else {
            return !studentModel.disableEnrollment(course);
        }
    }
}
