/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Named
@SessionScoped
@NoArgsConstructor
public class VideoModel implements Serializable {
    
    @Getter @Setter private String title;
    @Getter @Setter private String content;
    @Getter @Setter private String videoTitle;
    @Getter @Setter private String videoDescription;
    @Getter @Setter private String videoURL;
}
