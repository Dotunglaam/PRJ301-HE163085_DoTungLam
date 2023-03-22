/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dal.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modol.Dormitories;
import modol.Rooms;

/**
 *
 * @author ADMIN
 */
public class RoomUpdate extends HttpServlet {

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
            out.println("<title>Servlet RoomUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RoomUpdate at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("rid");
        RoomDAO r = new RoomDAO();
        Rooms room = r.get(id);
        request.setAttribute("room", room);
        request.getRequestDispatcher("view/roomUpdate.jsp").forward(request, response);
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
        String room_id = request.getParameter("room_id");
        String name = request.getParameter("name");
        String current_people = request.getParameter("current_people");
        String price = request.getParameter("price");
        String dormitory_id = request.getParameter("dormitory_id");
        String room_type = request.getParameter("room_type");
        String floor = request.getParameter("floor");
        String status = request.getParameter("status");
        if (Integer.parseInt(current_people) < Integer.parseInt(room_type)) {
            RoomDAO room = new RoomDAO();
            Rooms r = new Rooms();
            r.setRoom_id(Integer.parseInt(room_id));
            r.setName(name);
            r.setCurrent_people(Integer.parseInt(current_people));
            r.setPrice(Float.parseFloat(price));

            Dormitories d = new Dormitories();
            d.setDormitory_id(Integer.parseInt(dormitory_id));
            r.setDormitories(d);
            r.setRoom_type(Integer.parseInt(room_type));
            r.setFloor(Integer.parseInt(floor));
            r.setStatus(status);
            room.update(r);
            response.sendRedirect("room");
        } else {
            String id = request.getParameter("room_id");
            RoomDAO r = new RoomDAO();
            Rooms room = r.get(id);
            request.setAttribute("room", room);
            request.setAttribute("error", "Phòng đã đầy!");
            request.getRequestDispatcher("view/roomUpdate.jsp").forward(request, response);
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
