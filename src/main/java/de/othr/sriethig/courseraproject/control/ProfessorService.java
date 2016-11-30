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

//TODO: maybe add an abstract class for person (register, login, update params)

/**
 *
 * @author sonja
 */
@SessionScoped
@NoArgsConstructor
@Transactional(Transactional.TxType.REQUIRED)
public class ProfessorService implements Serializable {
    
    @Inject
    ProfessorRepository professorRepository;
    
    /**
     * 
     * @param professor
     * @return 
     */
    public Professor registerProfessor(Professor professor) {
        professorRepository.persist(professor);
        return professor;
    }    
    
    /**
     * 
     * @param professor
     * @return 
     */
    //TODO
    public Professor loginProfessor(Professor professor) {
        return null;
    }
    
    public List<Professor> getProfessors() {
        List<Professor> professors = professorRepository.getAllProfessors();
        return professors;
    }
     
    /**
     * 
     * @param professor
     * @param firstName
     * @return 
     */
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
    public Professor updateProfessorAddress(Professor professor,
            Address address) {
        professor = (Professor) professorRepository.merge(professor);
        professor.setAddress(address);
        return professor;
    }
    
    /**
     * 
     * @param professor
     * @return 
     */
    public List<Course> getCourses(Professor professor) {
        professor = (Professor) professorRepository.merge(professor);
        List<Course> courses =  (List) professor.getCourses();
        return courses;
    }
    
    /**
     * 
     * @param professor 
     */
    public void removeProfessor(Professor professor) {
        professorRepository.remove(professor);
    }
}
