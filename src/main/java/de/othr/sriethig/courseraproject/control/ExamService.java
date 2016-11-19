/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.repository.ExamRepository;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author sonja
 */
@Transactional
public class ExamService {
    
    @Inject
    ExamRepository examRepository;
    
    public ExamService() {
    }
    
    public Exam createExam(Exam exam) {
        examRepository.persist(exam);
        return exam;
    }
}
