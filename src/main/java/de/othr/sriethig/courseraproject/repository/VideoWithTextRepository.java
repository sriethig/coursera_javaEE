/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.VideoWithText;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonja
 */
public class VideoWithTextRepository extends
        SingleIdEntityRepository<Long, VideoWithText> {
    
    public VideoWithTextRepository() {
        super(VideoWithText.class);
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public VideoWithText findVideoWithTextByTitle(String title) {
        TypedQuery<VideoWithText> query = this.getEntityManager().createQuery("SELECT v FROM "
                + "VideoWithText WHERE v.title = :parametername", 
                this.getType() 
        );
        query.setParameter("parametername", title);
        VideoWithText videoWithText = (VideoWithText) query.getSingleResult();
        return videoWithText;
    }
}
