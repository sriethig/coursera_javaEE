/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Video;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 */
@RequestScoped
public class VideoRepository extends
        SingleIdEntityRepository<Long, Video> implements Serializable {
    
    public VideoRepository() {
        super(Video.class);
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public Video findVideoByTitle(String title) {
        TypedQuery<Video> query = this.createTypedQuery("SELECT v FROM "
                + "Video WHERE v.title = :1");
        query.setParameter("1", title);
        Video videoWithText = (Video) query.getSingleResult();
        return videoWithText;
    }
}
