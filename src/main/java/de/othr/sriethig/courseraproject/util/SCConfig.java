/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.util;

/**
 *
 * @author sonja
 */
public class SCConfig {
    
    public enum RunOption {
        Test,
        Productive
    };
    
    private static RunOption runOption = RunOption.Test;
    
    /**
     *
     * @return
     */
    public static RunOption getRunOption() {
        return runOption;
    }
    
}
