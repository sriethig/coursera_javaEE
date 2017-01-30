/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.repository.StudentRepository;
import de.othr.sriethig.courseraproject.service.ISNGroupService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author sonja
 */
@WebService(name = "SNGroupService", serviceName = "SNGroupService",
        targetNamespace = "webservices.sriethig_coursera.de")
public class SNGroupService implements ISNGroupService {
    
    @Inject
    private StudentRepository studentRepository;
    
    @Inject
    private Logger logger;

    /**
     * 
     * @param socialMediaId
     * @return 
     */
    @WebMethod(exclude = false)
    @Override
    public List<Long> getStudentsInTheSameCourseAs (
            @WebParam(name = "socialMediaId") Long socialMediaId) 
            throws NotFoundException {
        SNStudent snStudent = 
                studentRepository.findSNStudentBySocialMediaId(socialMediaId);
        if(snStudent == null) {
            logger.log(Level.SEVERE, "SNGroupService::getStudentsInTheSameCourseAs "
                    + "Student not found");
            throw new NotFoundException();
        }
        
        List<Course> courses = (List<Course>) snStudent.getCourses();
        if(courses == null || courses.isEmpty()) {
            System.err.print("SNGrouptService::getStudentsInTheSameCourseAs"
                    + " student is not enrolled in any courses");
            return null;
        }
        
        List<Long> students = new ArrayList<>();
        students.add(snStudent.getSocialMediaId());
        
        for(Course course : courses) {
            List<AbstractStudent> abstractStudents = 
                    (List<AbstractStudent>) course.getStudents();
            for(AbstractStudent abstractStudent : abstractStudents) {
                if(abstractStudent.getClass() == SNStudent.class) {
                    SNStudent s = (SNStudent) abstractStudent;
                    Long sId = s.getSocialMediaId();
                    if (!students.contains(sId)) {
                        students.add(sId);
                    }
                }
            }
        }
        
        if(students.isEmpty()) {
            return null;
        }
        
        return students;
    }
    
}
