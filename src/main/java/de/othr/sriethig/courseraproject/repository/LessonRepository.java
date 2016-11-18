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
 */
public class LessonRepository extends SingleIdEntityRepository {
    
    public LessonRepository(Class type) {
        super(type);
    }    
}
