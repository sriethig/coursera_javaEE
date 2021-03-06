/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.Video;
import de.othr.sriethig.courseraproject.repository.ExamRepository;
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
 * Service for all operations on the entity Lesson
 */
@SessionScoped
@NoArgsConstructor
public class LessonService implements Serializable {
    
    @Inject 
    private LessonRepository lessonRepository;
    
    @Inject
    private VideoRepository videoRepository;
    
    @Inject 
    private ExamRepository examRepository;
    
    
    /**
     * 
     * @param lesson
     * @return 
     */
    @Transactional
    public Lesson createLesson(Lesson lesson) {
        lessonRepository.persist(lesson);
        return lesson;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Lesson find(Long id) {
        Lesson lesson = lessonRepository.findById(id);
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
    @Transactional
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
    @Transactional
    public Lesson addLessonContent(Lesson lesson, String lessonContent) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        lesson.setLessonContent(lessonContent);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @return 
     */
    @Transactional
    public Lesson removeLessonContent(Lesson lesson) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        lesson.setLessonContent("");
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @param video
     * @return 
     */
    @Transactional
    public Lesson addVideo(Lesson lesson, Video video) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        video = (Video) videoRepository.merge(video);
        lesson.setVideo(video);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @return 
     */
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
    public void removeLesson(Lesson lesson) {
        lessonRepository.remove(lesson);
    }
}
