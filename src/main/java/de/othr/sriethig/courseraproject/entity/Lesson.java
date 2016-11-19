/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author sonja
 */
@Entity
public class Lesson extends SingleIdEntity {

    private String title;
    
    @ManyToOne
    private Course course;
    
    @OneToOne
    private VideoWithText videoWithText;
    @OneToOne
    private Exam exam;

    public Lesson() {
    }

    /**
     * 
     * @return 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return 
     */
    public Course getCourse() {
        return course;
    }

    /**
     * 
     * @param course 
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * 
     * @return 
     */
    public VideoWithText getVideoWithText() {
        return videoWithText;
    }

    /**
     * 
     * @param videoWithText 
     */
    public void setVideoWithText(VideoWithText videoWithText) {
        this.videoWithText = videoWithText;
    }

    /**
     * 
     * @return 
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * 
     * @param exam 
     */
    public void setExam(Exam exam) {
        this.exam = exam;
    }
  
}
