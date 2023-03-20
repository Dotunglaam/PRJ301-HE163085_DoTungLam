/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Users;

import dal.UsersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import modol.Users;


/**
 *
 * @author ADMIN
 */

public class Login extends HttpServlet {

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
            out.println("<title>Servlet Loginv2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Loginv2 at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
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
      
            String u = request.getParameter("user");
            String p = request.getParameter("pass");
            String r = request.getParameter("remenber");
            
//          create Cookies
            Cookie cu = new Cookie("cuser",u);
            Cookie cp = new Cookie("cpass",p);
            Cookie cr = new Cookie("cremenber",r);
            if(r != null){
                cu.setMaxAge(24*60*60); //1 day
                cp.setMaxAge(24*60*60);
                cr.setMaxAge(24*60*60); 
            }else{
                cu.setMaxAge(0); //delete cookies
                cp.setMaxAge(0);
                cr.setMaxAge(0); 
            }
            //save as browser
            response.addCookie(cu);
            response.addCookie(cp);
            response.addCookie(cr);
            UsersDAO logindao = new UsersDAO();
            Users a = logindao.getUsers(u, p);
            if (a == null){
                request.setAttribute("error", "Wrong username or password!");
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            } else { 
                HttpSession session = request.getSession();
                session.setAttribute("User", a);
                if(a.getRole_id() == 1){
//                    request.getRequestDispatcher("view/homeAdmin.jsp").forward(request, response);
                      response.sendRedirect("homea");
                }else{
//                    request.getRequestDispatcher("view/home.jsp").forward(request, response);
                        response.sendRedirect("home");
                }
                
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
