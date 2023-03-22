/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Users;

import dal.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import modol.Users;

/**
 *
 * @author ADMIN
 */
public class UpdateInforStudent extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateInforStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateInforStudent at " + request.getContextPath() + "</h1>");
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
        String sid = request.getParameter("sid");
        UsersDAO u = new UsersDAO();
        Users user = u.get(Integer.parseInt(sid));
        request.setAttribute("user", user);
        request.getRequestDispatcher("view/studentUpdateOfInfor.jsp").forward(request, response);
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
        String id = request.getParameter("user_id");
        String full_name = request.getParameter("full_name");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        boolean validPhone = false;
        if (phone != null && phone.startsWith("0") && phone.length() <= 10) {
            validPhone = true;
        }
        if (validPhone) {
            UsersDAO u = new UsersDAO();
            Users user = u.get(Integer.parseInt(id));
            user.setFull_name(full_name);
            user.setGender(gender.equals("male"));
            user.setDob(Date.valueOf(dob));
            user.setPhone(phone);
            u.updateUser(user);
            response.sendRedirect("home");
        } else {
            String sid = request.getParameter("user_id");
            UsersDAO u = new UsersDAO();
            Users user = u.get(Integer.parseInt(sid));
            request.setAttribute("user", user);
            request.setAttribute("error", "SDT phải bắt đầu là 0 và có 10 số !");
            request.getRequestDispatcher("view/studentUpdateOfInfor.jsp").forward(request, response);
        }

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
