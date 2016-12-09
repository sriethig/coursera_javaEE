/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.ExamResult;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.repository.ExamRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@SessionScoped
@NoArgsConstructor
public class ExamService implements Serializable {
    
    @Inject
    ExamRepository examRepository;
    
    /**
     * 
     * @param exam
     * @return 
     */
    @Transactional
    public Exam createExam(Exam exam) {
        examRepository.persist(exam);
        return exam;
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public Exam findExamByTitle(String title) {
        Exam exam = (Exam) examRepository.findExamByTitle(title);
        return exam;
    }
    
    /**
     * 
     * @param exam
     * @param title
     * @return 
     */
    public Exam updateTitle(Exam exam, String title) {
        exam = (Exam) examRepository.merge(exam);
        exam.setTitle(title);
        return exam;
    }
    
    /**
     * 
     * @param exam
     * @return 
     */
    public Lesson getLesson(Exam exam) {
        exam = (Exam) examRepository.merge(exam);
        Lesson lesson = exam.getLesson();
        return lesson;
    }
    
    /**
     * 
     * @param exam
     * @return 
     */
    public List<String> getQuestion(Exam exam) {
        exam = (Exam) examRepository.merge(exam);
        List<String> questions = exam.getQuestions();
        return questions;
    }
    
    /**
     * 
     * @param exam
     * @param question
     * @return 
     */
    @Transactional
    public List<String> addQuestion(Exam exam, String question) {
        exam = (Exam) examRepository.merge(exam);
        List<String> questions = exam.getQuestions();
        if(!questions.contains(question)) {
            questions.add(question);
        }
        return questions;
    }
    
    /**
     * 
     * @param exam
     * @param question
     * @return 
     */
    @Transactional
    public List<String> removeQuestion(Exam exam, String question) {
        exam = (Exam) examRepository.merge(exam);
        List<String> questions = exam.getQuestions();
        if(questions.contains(question)) {
            questions.remove(question);
        }
        return questions;
    }
    
    /**
     * 
     * @param exam
     * @return 
     */
    public List<ExamResult> getResults(Exam exam) {
        exam = (Exam) examRepository.merge(exam);
        List<ExamResult> results = (List) exam.getResults();
        return results;
    }
    
    /**
     * 
     * @param exam
     * @return 
     */
    public HashMap<String, Double> getExamStatistics(Exam exam) {
        exam = (Exam) examRepository.merge(exam);
        List<ExamResult> results = (List) exam.getResults();
        
        List<Integer> singleResults = new ArrayList<>();
        for(ExamResult result : results) {
            singleResults.add(result.getScore());
        }
        
        HashMap<String, Double> statistics = new HashMap<>();
        statistics.put("Average", singleResults.stream().mapToDouble(a->a)
                .average().getAsDouble());
        statistics.put("Min", singleResults.stream().mapToDouble(a->a)
                .min().getAsDouble());
        statistics.put("Max", singleResults.stream().mapToDouble(a->a)
                .max().getAsDouble());
        return statistics;
    }
    
    /**
     * 
     * @param exam 
     */
    @Transactional
    public void removeExam(Exam exam) {
        exam = (Exam) examRepository.merge(exam);
        examRepository.remove(exam);
    }
}
