/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Country;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author sonja
 * @param <Long>
 * @param <Student>
 */

@Transactional
public class StudentRepository<Long, Student> extends SingleIdEntityRepository {
    
    public StudentRepository(Class type) {
        super(type);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public Student findStudentByName(String name) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT s FROM "
                + "Student AS s WHERE s.name = :parametername", 
                this.getType()
        ); 
        query.setParameter("parametername", name);
        Student student = (Student) query.getSingleResult();
        return student;
    }
    
    /**
     * 
     * @param country
     * @return 
     */
    //TODO: resolve country
    public List<Student> findStudentByCountry(Country country) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT s FROM "
            + "Student AS s WHERE s.country = :paramertername",
            this.getType()    
        );
        query.setParameter("parametername", country);
        List<Student> students = query.getResultList();
        return students;
    }
}
