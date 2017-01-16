/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
public class Exam extends SingleIdEntity<Long> {

    @Getter @Setter private String title; 
    @ElementCollection
    @Getter @Setter private List<String> questions;
    
    @OneToOne(mappedBy="exam", cascade={CascadeType.PERSIST})
    @Getter @Setter private Lesson lesson;
    
    @OneToMany(mappedBy="exam", cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Setter private Collection<ExamResult> results;
    
    /**
     * 
     * @return 
     */
    public List<ExamResult> getResults() {
        return Collections.unmodifiableList((List<ExamResult>) this.results);
    }
    
}
