/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.ExamResult;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;

/**
 *
 * @author sonja
 */
public class ExamResultRepository extends SingleIdEntityRepository<Long, ExamResult> {
    
    public ExamResultRepository() {
        super(ExamResult.class);
    }
    
}
