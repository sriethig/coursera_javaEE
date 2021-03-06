/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.CourseService;
import de.othr.sriethig.courseraproject.control.LessonService;
import de.othr.sriethig.courseraproject.control.VideoService;
import de.othr.sriethig.courseraproject.entity.BookProxy;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.Video;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.faces.convert.LessonConverter;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Named
@SessionScoped
@NoArgsConstructor
public class CourseModel implements Serializable {
    
    @Getter @Setter private Course course;
    @Getter @Setter private String title;
    @Getter @Setter private String description;
    @Setter private List<Lesson> lessons;
    
    @Getter @Setter private Lesson lesson = null;
    @Getter @Setter private String lessonTitle;
    @Getter @Setter private String lessonContent;
    @Getter @Setter private String lessonVideoTitle;
    @Getter @Setter private String lessonVideoDescription;
    @Getter @Setter private String lessonVideoURL;
    
    @Getter @Setter private List<BookProxy> books;
    
    @Inject
    private LoginModel loginModel;
    
    @Inject
    private StudentModel studentModel;
    
    @Inject 
    private ProfessorModel professorModel;
    
    @Inject
    private CourseService courseService;
    
    @Inject
    private LessonService lessonService;
    
    @Inject
    private VideoService videoService;
    
    @Inject
    @Getter
    @Setter
    private LessonConverter lessonConverter;
    
    @Inject
    private Logger logger;
    
    /**
     * 
     */
    public void initialize() {
        logger.log(Level.WARNING, "CourseModel::initialize");
        if(loginModel.isAuthorizedProfessor()) {
            this.course = professorModel.getDetailCourse();
            logger.log(Level.WARNING, "CourseModel::initialize prof");
        } else if(loginModel.isAuthorizedStudent()) {
            this.course = studentModel.getDetailCourse();
            logger.log(Level.WARNING, "CourseModel::initialize stud");
        }
        title = this.course.getTitle();
        description = this.course.getDescription();
        lessons = (List<Lesson>) this.course.getLessons();
        books = courseService.getBooksForCourse(this.title);
    }
    
    /**
     * fetch lessons from server when page is loaded
     * in case a professor added a lesson during the session
     * @return 
     */
    public List<Lesson> getLessons() {
        this.lessons = courseService.getLessons(this.course);
        return this.lessons;
    }
    
    /**
     * 
     * @return 
     */
    public String enrollInThisCourse() {
        studentModel.enrollInCourse(this.course);
        return "show_course";
    }
    
    /**
     * 
     */
    public void updateCourse() {
        course = courseService.updateCourseTitle(this.course, this.title);
        course = courseService.updateCourseDescription(this.course, this.description);
    }
    
    /**
     * 
     */
    public void changeLesson() {
        
    }
    
    /**
     * 
     */
    public void updateLesson() {
        
    }
    
    /**
     * 
     */
    public void addLesson() {
        Lesson newLesson = new Lesson();
        newLesson.setTitle(this.lessonTitle);
        newLesson.setLessonContent(this.lessonContent);
        
        Video video = new Video();
        video.setTitle(this.lessonVideoTitle);
        video.setDescription(this.lessonVideoDescription);
        video.setUrl(this.lessonVideoURL);
        
        /*lessonService.createLesson(lesson);
        videoService.createVideo(video);
        lesson = lessonService.addVideo(lesson, video);*/
        newLesson.setVideo(video);
        newLesson = lessonService.createLesson(newLesson);
    }
    
    /**
     * 
     * @return 
     */
    public String goBack() {
        if(loginModel.isAuthorizedProfessor()) {
            return "professor";
        } else if(loginModel.isAuthorizedStudent()) {
        studentModel.setDetailCourse(null);
            return "student";
        } else {
            return "login";
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
