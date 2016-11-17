/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;

/**
 *
 * @author sonja
 */
public class SNStudent extends AbstractStudent {
    
    private String socialMediaId;

    /**
     * 
     * @return 
     */
    public String getSocialMediaId() {
        return socialMediaId;
    }

    /**
     * 
     * @param socialMediaId 
     */
    public void setSocialMediaId(String socialMediaId) {
        this.socialMediaId = socialMediaId;
    }

}
