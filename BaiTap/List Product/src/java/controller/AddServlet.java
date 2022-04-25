/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Dung
 */
public class AddServlet extends HttpServlet {

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
            out.println("<title>Servlet AddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
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
//        String code = request.getParameter("code");
//        String des = request.getParameter("description");
//        String cost = request.getParameter("cost");
        String value = request.getParameter("lc");
        if (value.equals("Add Product")) {
            String code = request.getParameter("code");
            String des = request.getParameter("description");
            String cost = request.getParameter("cost");
            String message_code = "";
            String message_des = "";
            String message_cost = "";
            if (code == null || code.isEmpty()) {
                message_code = "You must enter a code for the product";
                request.setAttribute("message_code", message_code);
            }
            if (des == null || des.isEmpty()) {
                message_des = "You must enter a description for the product";
                request.setAttribute("message_des", message_des);
            }
            if (cost == null || cost.isEmpty()) {
                message_cost = "You must enter a cost for the product";
                request.setAttribute("message_cost", message_cost);
            }
            if (message_code != "" | message_des != "" | message_cost != "") {
                request.getRequestDispatcher("add.jsp").forward(request, response);
            }else{
                ProductIO p = new ProductIO();
                Product pi = new Product(code, des, cost);
                p.insert(pi);
                response.sendRedirect("list");
            }
        }else{
            response.sendRedirect("list");
        }
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
