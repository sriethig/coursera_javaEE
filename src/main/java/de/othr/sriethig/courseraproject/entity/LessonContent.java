/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LessonContent extends SingleIdEntity{
    
    @Getter @Setter private String title;  
    @Getter @Setter private String text;
    
    @OneToOne(mappedBy="lessonContent")
    @Getter @Setter private Lesson lesson;
    
}
