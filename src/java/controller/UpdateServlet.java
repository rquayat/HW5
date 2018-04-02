/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbHelpers.UpdateQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.JobLeads;

/**
 *
 * @author rquayat
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/updatelead"})
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        
    //get the form data and set up a lead object
        int lead_id = Integer.parseInt(request.getParameter("lead_id"));
        String company = request.getParameter("company");
        String position = request.getParameter("position");
        String location = request.getParameter("location");
        String contact_name = request.getParameter("contactName");
        String contact_method = request.getParameter("contactMethod");
        String notes = request.getParameter("notes");
        String contact_date = request.getParameter("contactDate");
        
        JobLeads lead = new JobLeads();
        lead.setlead_id(lead_id);
        lead.setcompany(company);
        lead.setposition(position);
        lead.setlocation(location);
        lead.setcontact_name(contact_name);
        lead.setcontact_method(contact_method);
        lead.setnotes(notes);
        lead.setcontact_date(contact_date);
       
    //create an UpdateQuery object and use it to update the lead
    UpdateQuery uq = new UpdateQuery();
    uq.doUpdate(lead);
    
    //pass control to the ReadServlet
    String url = "read/";
        
                
        
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
