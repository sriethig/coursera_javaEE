/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author sonja
 */
@Entity
public class Exam extends SingleIdEntity {

    private String title;
    
    private List<String> questions;
    
    @OneToOne(mappedBy="exam", cascade={CascadeType.PERSIST})
    private Lesson lesson;
    
    @OneToMany(mappedBy="exam", cascade={CascadeType.PERSIST})
    private Collection<ExamResult> results;

    public Exam() {
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
     * @param examTitle 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return 
     */
    public List<String> getQuestions() {
        return questions;
    }

    /**
     * 
     * @param questions 
     */
    public void setQuestion(List<String> questions) {
        this.questions = questions;
    }
    
    /**
     * 
     * @param question 
     */
    public void addQuestion(String question) {
        this.questions.add(question);
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

    /**
     * 
     * @return 
     */
    public Collection<ExamResult> getResults() {
        return results;
    }

    /**
     * 
     * @param results 
     */
    public void setResults(Collection<ExamResult> results) {
        this.results = results;
    }
}
