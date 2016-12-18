/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Country;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.SCStudent;
import de.othr.sriethig.courseraproject.entity.Video;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@SessionScoped
@NoArgsConstructor
public class DummyDataService implements Serializable {
    
    @Getter @Setter private boolean isDataSeeded = false;
    
    @Inject
    private StudentService studentService;
    
    @Inject
    private CourseService courseService;
    
    @Inject
    private LessonService lessonService;
    
    @Inject
    private ProfessorService professorService;
    
    /**
     * 
     */
    @Transactional
    public void insertDummyData() {
        if(!this.isDataSeeded) {
            seedStudents();
            List<Course> courses = seedCourses();
            seedProfessors(courses);
            
            this.isDataSeeded = true;
        }  
    }
    
    /**
     * 
     * @return 
     */
    public List<SCStudent> seedStudents() {
        List<SCStudent> students = new ArrayList<>();
        
        String[] firstNames = {
                "Max",
                "Maria",
                "Marlene",
                "Natalie",
                "Nathan", 
                "test"
            };
            String[] names = {
                "Mustermann",
                "Mustermann",
                "Dieter",
                "Portmonnaie",
                "Weise", 
                "student"
            };
            for(int i = 0; i < firstNames.length; i++) {
                SCStudent s = new SCStudent();
                s.setFirstName(firstNames[i]);
                s.setName(names[i]);
                s.setEmailAddress(firstNames[i] + "." + names[i] + 
                        "@st.oth-regensburg.de");
                s.setPassword(firstNames[i]);
                s.setAddress(new Address("Galgenbergstr. " + i, 93049, 
                        "Regensburg", Country.GER));
                s = (SCStudent) studentService.registerStudent(s);
                students.add(s);
            }
            
            return students;
    }
    
    /**
     * 
     * @param standardLesson
     * @return 
     */
    public List<Course> seedCourses() {
        List<Course> courses = new ArrayList<>();
        
        String[] courseTitles = {
                "HCI - Human Computer Interaction",
                "Java for Beginners",
                "UML Diagrams for the Daily Use",
                "Databases with SQL"
            };
            String[] courseDescriptions = {
                "Design your applications not only beautifully, but also more "
                    + "functional with easy techniques.",
                "Java is the best programming language in the history of "
                    + "computer science. So get on the train and code away. "
                    + "It's as easy as that.",
                "Nice pictures, neat squares, arrows all over the place - "
                    + "sounds like fun? Yes, it is, so check out this course"
                    + "and start designing UML diagrams for your daily use.",
                "In this course you will build an example database for your "
                    + "bike collection and learn to query them with the "
                    + "almighty SQL."
            };
            for(int i = 0; i < courseTitles.length; i++) {
                Course c = new Course();
                c.setTitle(courseTitles[i]);
                c.setDescription(courseDescriptions[i]);
                c = courseService.createCourse(c);
                
                Lesson lesson = seedLesson();
                c = courseService.addLesson(c, lesson);
                courses.add(c);
                System.out.println("DummyDataService::seedCourses " + c.getTitle() + " " + c.getLessons().size());
            }
            
            return courses;
    }
    
    public Lesson seedLesson() {
                
        Lesson standardLesson = new Lesson();
        standardLesson.setTitle("General Introduction");
        standardLesson.setLessonContent("In the following video, the main "
                + "principles of all courses are explained. Please watch it "
                + "carefully and after that go to the exam.");
        
        Video standardVideo = new Video();
        standardVideo.setTitle("Intro");
        standardVideo.setDescription("Watch carefully!");
        standardVideo.setUrl("https://www.youtube.com/embed/QH2-TGUlwu4");
        standardLesson.setVideo(standardVideo);
        
        Exam standardExam = new Exam();
        standardExam.setTitle("Did you watch carefully?");
        List<String> questions = new ArrayList<>();
        questions.add("Which animal is shown in the video?");
        standardExam.setQuestions(questions);
        standardLesson.setExam(standardExam);
        
        standardLesson = lessonService.createLesson(standardLesson);

        return standardLesson;
    }
    
    /**
     * 
     * @param courses
     * @return 
     */
    public List<Professor> seedProfessors(List<Course> courses) {
        List<Professor> professors = new ArrayList<>();
        
        String profFirstNames[] = {
                "David",
                "Mark",
                "Flo",
                "test"
            };
            String profNames[] = {
                "Obst",
                "Busch",
                "Yd", 
                "prof"
            };
            for(int i = 0; i < profFirstNames.length; i++) {
                Professor p = new Professor();
                p.setFirstName(profFirstNames[i]);
                p.setName(profNames[i]);
                p.setAddress(new Address("Gelehrtengasse " + i, 93049, 
                        "Regensburg", Country.GER));
                p.setEmailAddress(profFirstNames[i] + "." + profNames[i] +
                        "@oth-regensburg.de");
                p.setPassword(profFirstNames[i]);
                courseService.addProfessor(courses.get(i), p);
                p = professorService.registerProfessor(p); 
                professors.add(p);
            }
            
            return professors;
    }
    
}
