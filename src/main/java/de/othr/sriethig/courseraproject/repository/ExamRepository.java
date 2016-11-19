/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;

/**
 *
 * @author sonja
 * @param <Long>
 * @param <Exam>
 */
public class ExamRepository<Long, Exam> extends SingleIdEntityRepository {
    
    public ExamRepository(Class type) {
        super(type);
    }
    
}
