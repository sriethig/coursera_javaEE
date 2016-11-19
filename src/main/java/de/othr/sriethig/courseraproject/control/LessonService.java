/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.VideoWithText;
import de.othr.sriethig.courseraproject.repository.LessonRepository;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author sonja
 */
@Transactional
public class LessonService {
    
    @Inject 
    LessonRepository lessonRepository;
    
    public LessonService() {
    }
    
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
     * @param videoWithText
     * @return 
     */
    public Lesson addVideoWithText(Lesson lesson, VideoWithText videoWithText) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        lesson.setVideoWithText(videoWithText);
        return lesson;
    }
    
    /**
     * 
     * @param lesson
     * @return 
     */
    public Lesson removeVideoWithText(Lesson lesson) {
        lesson = (Lesson) lessonRepository.merge(lesson);
        lesson.setVideoWithText(null);
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
        lesson.setExam(null);
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
