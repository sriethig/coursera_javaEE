/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.LessonContent;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author sonja
 */
@SessionScoped
public class LessonContentRepository extends
        SingleIdEntityRepository<Long, LessonContent> implements Serializable {
    
    public LessonContentRepository() {
        super(LessonContent.class);
    }
    
}
