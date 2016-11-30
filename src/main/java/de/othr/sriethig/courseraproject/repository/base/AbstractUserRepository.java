/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository.base;

import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 */
@SessionScoped
public class AbstractUserRepository extends 
        SingleIdEntityRepository<Long, AbstractUser> implements Serializable {
    
    public AbstractUserRepository() {
        super(AbstractUser.class);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public AbstractUser authenticateAbstractUser(String email, String password) {
        System.out.println("in authenticate(AbstractUserRepo)");
        TypedQuery<AbstractUser> query = this.createTypedQuery(
                "SELECT u FROM AbstractUser u WHERE u.name LIKE :parameter"
        );
        query.setParameter("parameter", "Obst");
        System.out.println("query fired");
        AbstractUser abstractUser = query.getResultList().get(0);
        System.out.println("result: " + abstractUser.getEmailAddress());
        return abstractUser;
    }
    
    /**
     * 
     * @param firstName
     * @return 
     */
    public List<AbstractUser> findByFirstName(String firstName) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT u FROM "
                + "AbstractUser AS u WHERE u.firstName = :parametername", 
                this.getType()
        ); 
        query.setParameter("parametername", firstName);
        List<AbstractUser> abstractUsers = (List<AbstractUser>) query.getResultList();
        return abstractUsers;
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public List<AbstractUser> findByName(String name) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT u FROM "
                + "AbstractUser AS u WHERE u.name = :parametername", 
                this.getType()
        ); 
        query.setParameter("parametername", name);
        List<AbstractUser> abstractUsers = (List<AbstractUser>) query.getResultList();
        return abstractUsers;
    }
    
    
}
