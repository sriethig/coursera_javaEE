/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository.base;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sonja
 * @param <K>
 * @param <E>
 */
public abstract class SingleIdEntityRepository<K, E extends SingleIdEntity> implements Serializable {
    
    @PersistenceContext(unitName="courseraPU")
    private EntityManager entityManager;
    
    private final Class<E> type;

    /**
     * 
     * @param type 
     */
    public SingleIdEntityRepository(Class<E> type) {
        this.type = type;
    }

    /**
     * 
     * @return 
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * 
     * @param entityManager 
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * 
     * @return 
     */
    public Class<E> getType() {
        return type;
    }
    
    /**
     * 
     * @param entity 
     */
    public void persist(E entity) {
        this.entityManager.persist(entity);
    }
    
    /**
     * 
     * @param entity
     * @return 
     */
    public E merge(E entity) {
        return this.entityManager.merge(entity);
    }
    
    /**
     * 
     * @param entity 
     */
    public void remove(E entity) {
        this.entityManager.remove(entity);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public E findById(K id) {
        return this.entityManager.find(type, id);
    }
    
    /**
     * 
     * @return 
     */
    public List<E> findAll() {
        return null;
    }
    
    /**
     * 
     * @param from
     * @param to
     * @return 
     */
    public List<E> findByRange(int from, int to) {
        return null;
    }  
}
