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
public class ExamResult extends SingleIdEntity {
    
    @Getter @Setter private List<String> answers;
    //score of the exam: can reach from 0 to 100 points
    //where 100 points is the best score
    @Getter @Setter private int score;
    
    @ManyToOne
    @Getter @Setter private Exam exam;
    
    @ManyToOne
    @Getter @Setter private AbstractStudent student;

}
