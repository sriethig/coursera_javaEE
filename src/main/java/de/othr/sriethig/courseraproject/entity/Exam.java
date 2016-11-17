/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author sonja
 */
@Entity
public class Exam extends SingleIdEntity {

    private String examTitle;
    
    private List<String> questions;
    private List<String> answers;
    private List<Integer> possiblePointsForAnswers;
    private List<Integer> pointsForAnswers;
    
    @OneToOne(mappedBy="exam")
    private Lesson lesson;

    public Exam() {
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestion(List<String> questions) {
        this.questions = questions;
    }
    
    public void addQuestion(String question) {
        this.questions.add(question);
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    
    public void addAnswer(String answer) {
        this.answers.add(answer);
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
    public List<Integer> getPossiblePointsForAnswers() {
        return possiblePointsForAnswers;
    }
    
    public int getPossiblePointsForAnswersAt(int index) {
        return possiblePointsForAnswers.get(index);
    }

    public void setPossiblePointsForAnswers(List<Integer> possiblePointsForAnswers) {
        this.possiblePointsForAnswers = possiblePointsForAnswers;
    }
    
    public void setPossiblePointsForAnswerAt(int index, int possiblePointsForAnswer) {
        this.possiblePointsForAnswers.set(index, possiblePointsForAnswer);
    }
    
    public List<Integer> getPointsForAnswers() {
        return pointsForAnswers;
    }
    
    public int getPointsForAnswersAt(int index) {
        return this.pointsForAnswers.get(index);
    }

    public void setPointsForAnswers(List<Integer> pointsForAnswers) {
        this.pointsForAnswers = pointsForAnswers;
    }
    
    public void setPointsForAnswerAt(int index, int pointsForAnswer) {
        this.pointsForAnswers.set(index, pointsForAnswer);
    }
    
}
