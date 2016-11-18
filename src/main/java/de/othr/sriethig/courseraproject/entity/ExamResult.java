/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author sonja
 */
@Entity
public class ExamResult extends SingleIdEntity {
    
    private List<String> answers;
    //result of the exam: can reach from 0 to 100 points
    //where 100 points is the best result
    private int result;
    
    @ManyToOne
    private Exam exam;
    
    @ManyToOne
    private AbstractStudent student;

    public ExamResult() {
    }

    /**
     * 
     * @return 
     */
    public List<String> getAnswers() {
        return answers;
    }

    /**
     * 
     * @param answers 
     */
    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    
    /**
     * 
     * @param answer 
     */
    public void addAnswer(String answer) {
        this.answers.add(answer);
    }
    
    /**
     * 
     * @param index
     * @param answer 
     */
    public void addAnswerAt(int index, String answer) {
        this.answers.add(index, answer);
    }
    
    /**
     * 
     * @return 
     */
    public int getResult() {
        return result;
    }

    /**
     * 
     * result has to be between 0 and 100
     * @param result
     */
    public void setResult(int result) {
        this.result = result;
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

    /**
     * 
     * @return 
     */
    public AbstractStudent getStudent() {
        return student;
    }

    /**
     * 
     * @param student 
     */
    public void setStudent(AbstractStudent student) {
        this.student = student;
    }
          
}
