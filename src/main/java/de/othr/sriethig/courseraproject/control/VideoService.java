/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Video;
import de.othr.sriethig.courseraproject.repository.VideoRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@SessionScoped
@NoArgsConstructor
public class VideoService implements Serializable {
    
    @Inject
    VideoRepository videoRepository;
    
    /**
     * 
     * @param video
     * @return 
     */
    @Transactional
    public Video createVideo(Video video) {
        videoRepository.persist(video);
        return video;
    }
    
    /**
     * 
     * @param video 
     */
    public void removeVideo(Video video) {
        video = (Video) videoRepository.merge(video);
        videoRepository.remove(video);
    }
}
