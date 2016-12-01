/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.LessonContent;
import de.othr.sriethig.courseraproject.entity.Video;
import de.othr.sriethig.courseraproject.repository.ExamRepository;
import de.othr.sriethig.courseraproject.repository.LessonContentRepository;
import de.othr.sriethig.courseraproject.repository.LessonRepository;
import de.othr.sriethig.courseraproject.repository.VideoRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@SessionScoped
@Transactional
@NoArgsConstructor
public class LessonService implements Serializable {
    
    @Inject 
    LessonRepository lessonRepository;
    
    @Inject
    LessonContentRepository lessonContentRepository;
    
    @Inject
    VideoRepository videoRepository;
    
    @Inject 
    ExamRepository examRepository;
    
    /**
     * 
     * @param lesson
     * @return 
     */
    public Lesson createLesson(Lesson lesson) {
        lessonRepository.persist(lesson);
        return lesson;
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public Lesson findLessonByTitle(String title) {
        Lesson lesson = lessonRepository.findLessonByTitle(title);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @param title
     * @return 
     */
    public Lesson updateTitle(Lesson lesson, String title) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        lesson.setTitle(title);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @param lessonContent
     * @return 
     */
    public Lesson addLessonContent(Lesson lesson, LessonContent lessonContent) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        lesson.setLessonContent(lessonContent);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @return 
     */
    public Lesson removeLessonContent(Lesson lesson) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        LessonContent lessonContent = lesson.getLessonContent();
        lesson.setLessonContent(null);
        lessonContentRepository.remove(lessonContent);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @param video
     * @return 
     */
    public Lesson addVideo(Lesson lesson, Video video) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        lesson.setVideo(video);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @return 
     */
    public Lesson removeVideo(Lesson lesson) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        Video video = lesson.getVideo();
        lesson.setVideo(null);
        videoRepository.remove(video);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @param exam
     * @return 
     */
    public Lesson addExam(Lesson lesson, Exam exam) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        lesson.setExam(exam);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @return 
     */
    public Lesson removeExam(Lesson lesson) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        Exam exam = lesson.getExam();
        lesson.setExam(null);
        examRepository.remove(exam);
        return lesson;
    }
    
    /**
     * 
     * @param lesson 
     */
    public void removeLesson(Lesson lesson) {
        lessonRepository.remove(lesson);
    }
}
