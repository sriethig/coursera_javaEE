/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.VideoWithText;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 */
@RequestScoped
public class VideoWithTextRepository extends
        SingleIdEntityRepository<Long, VideoWithText> implements Serializable {
    
    public VideoWithTextRepository() {
        super(VideoWithText.class);
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public VideoWithText findVideoWithTextByTitle(String title) {
        TypedQuery<VideoWithText> query = this.createTypedQuery("SELECT v FROM "
                + "VideoWithText WHERE v.title = :1");
        query.setParameter("1", title);
        VideoWithText videoWithText = (VideoWithText) query.getSingleResult();
        return videoWithText;
    }
}
