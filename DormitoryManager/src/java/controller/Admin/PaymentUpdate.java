/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dal.PaymentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import modol.Payments;
import modol.Rooms;
import modol.Users;

/**
 *
 * @author ADMIN
 */
public class PaymentUpdate extends HttpServlet {

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
            out.println("<title>Servlet PaymentUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentUpdate at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("pid");
        PaymentDAO p = new PaymentDAO();
        Payments pay = p.get(Integer.parseInt(id));
        request.setAttribute("pay", pay);
        request.getRequestDispatcher("view/paymentUpdate.jsp").forward(request, response);
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
        String id = request.getParameter("pid");
        String user_id = request.getParameter("user_id");
        String room_id = request.getParameter("room_id");
        String amount = request.getParameter("amount");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        PaymentDAO p = new PaymentDAO();
        Payments pay = p.get(Integer.parseInt(id));
        Users u = new Users();
        u.setUser_id(Integer.parseInt(user_id));
        pay.setUsers(u);    
        Rooms r = new Rooms();
        r.setRoom_id(Integer.parseInt(room_id));
        pay.setRooms(r);
        pay.setAmount(Float.parseFloat(amount));
        pay.setPayment_date(Date.valueOf(date));
        pay.setStatus(status);        

//        System.out.println(pay)
        p.update(pay);
//            response.getWriter().println("inserted succesful!");
        response.sendRedirect("payment");

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
