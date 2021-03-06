/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.repository.ProfessorRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 * Service for all operations on the entity Professor
 */
@SessionScoped
@NoArgsConstructor
public class ProfessorService implements Serializable {
    
    @Inject
    ProfessorRepository professorRepository;
    
    /**
     * persist an object of Professor
     * @param professor
     * @return 
     */
    @Transactional
    public Professor registerProfessor(Professor professor) {
        professorRepository.persist(professor);
        return professor;
    }    
    
    /**
     * get all the professors of Sonja's Coursera
     * @return 
     */
    public List<Professor> getProfessors() {
        List<Professor> professors = professorRepository.findAll();
        return professors;
    }
     
    /**
     * 
     * @param professor
     * @param firstName
     * @return 
     */
    @Transactional
    public Professor updateProfessorFirstName(Professor professor, 
            String firstName) {
        professor = (Professor) professorRepository.merge(professor);
        professor.setFirstName(firstName);
        return professor;
    }
    
    /**
     * 
     * @param professor
     * @param name
     * @return 
     */
    @Transactional
    public Professor updateProfessorName(Professor professor,
            String name) {
        professor = (Professor) professorRepository.merge(professor);
        professor.setName(name);
        return professor;
    }
    
    /**
     * 
     * @param professor
     * @param address
     * @return 
     */
    @Transactional
    public Professor updateProfessorAddress(Professor professor,
            Address address) {
        professor = (Professor) professorRepository.merge(professor);
        professor.setAddress(address);
        return professor;
    }
    
    /**
     * get all the courses of an object of Professor
     * @param professor
     * @return 
     */
    @Transactional // Transactional Required
    public List<Course> getCourses(Professor professor) {
        professor = (Professor) professorRepository.merge(professor);
        List<Course> courses =  (List) professor.getCourses();
        return courses;
    }
    
    /**
     * delete Professor from database
     * @param professor 
     */
    @Transactional
    public void removeProfessor(Professor professor) {
        professorRepository.remove(professor);
    }
}
