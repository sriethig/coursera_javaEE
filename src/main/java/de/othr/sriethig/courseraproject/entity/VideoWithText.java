/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author sonja
 */
@Entity
public class VideoWithText extends SingleIdEntity {

    private String title;  
    private String description;
    private String url;
    
    @OneToOne(mappedBy="videoWithText")
    private Lesson lesson;

    /**
     * 
     */
    public VideoWithText() {
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
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return 
     */
    public Lesson getLesson() {
        return lesson;
    }

    /**
     * 
     * @param lesson 
     */
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    } 
}
