/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.boundary;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Country;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.SCStudent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sonja
 */
@WebServlet(name = "DummyDataServlet", urlPatterns = {"/DummyDataServlet"})
public class DummyDataServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DummyDataServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String[] firstNames = {
                "Max",
                "Maria",
                "Marlene",
                "Natalie",
                "Nathan"
            };
            String[] names = {
                "Mustermann",
                "Mustermann",
                "Dietrich",
                "Portman",
                "Weise"
            };
            String[] emails;
            for(int i = 0; i < firstNames.length; i++) {
                SCStudent s = new SCStudent();
                s.setFirstName(firstNames[i]);
                s.setName(names[i]);
                s.setEmailAddress(firstNames[i] + "." + names[i] + 
                        "@st.oth-regensburg.de");
                s.setPassword(firstNames[i]);
                s.setAddress(new Address("Galgenbergstr. " + i, 93049, 
                        "Regensburg", Country.GER));
            }
                        
            String[] courseTitles = {
                "HCI - Human Computer Interaction",
                "Java for Beginners",
                "UML Diagrams for the Daily Use"
            };
            String[] courseDescriptions = {
                "Design your applications not only beautifully, but also more "
                    + "functional with easy techniques.",
                "Java is the best programming language in the history of "
                    + "computer science. So get on the train and code away. "
                    + "It's as easy as that.",
                "Nice pictures, neat squares, arrows all over the place - "
                    + "sounds like fun? Yes, it is, so check out this course"
                    + "and start designing UML diagrams for your daily use."
            };
            List<Course> courses = new ArrayList<>();
            for(int i = 0; i < courseTitles.length; i++) {
                Course c = new Course();
                c.setTitle(courseTitles[i]);
                c.setDescription(courseDescriptions[i]);
                courses.add(c);
            }
            
            String profFirstNames[] = {
                "David",
                "Mark",
                "Flo"
            };
            String profNames[] = {
                "Obst",
                "Busch",
                "Yd"
            };
            for(int i = 0; i < profFirstNames.length; i++) {
                Professor p = new Professor();
                p.setFirstName(profFirstNames[i]);
                p.setFirstName(profNames[i]);
                p.setAddress(new Address("Gelehrtengasse " + i, 93049, 
                        "Regensburg", Country.GER));
                p.setEmailAddress(profFirstNames[i] + "." + profNames[i] +
                        "@oth-regensburg.de");
                p.setPassword(profFirstNames[i]);
                p.setCourses(courses.subList(i, i));
            }
            
            out.println("<h1>Servlet DummyDataServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
