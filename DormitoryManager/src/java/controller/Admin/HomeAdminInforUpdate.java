/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dal.InforDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import modol.Informations;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author ADMIN
 */
public class HomeAdminInforUpdate extends HttpServlet {

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
            out.println("<title>Servlet HomeAdminInforUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeAdminInforUpdate at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("inid");
        InforDAO i = new InforDAO();
        Informations in = i.get(Integer.parseInt(id));
        request.setAttribute("in", in);
        request.getRequestDispatcher("view/homeAInforUpdate.jsp").forward(request, response);
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

        String id = request.getParameter("id");
        String rrdString = request.getParameter("rrd");
        String cdString = request.getParameter("cd");

        // Chuyển đổi chuỗi ngày thành đối tượng LocalDate
        LocalDate rrd = LocalDate.parse(rrdString);
        LocalDate cd = LocalDate.parse(cdString);

        // Tính số tháng giữa hai ngày
        long monthsBetween = ChronoUnit.MONTHS.between(rrd, cd);

        //Kiểm tra nếu khoảng thời gian
        if (monthsBetween < 1) {
            // Gửi thông báo lỗi tới trang web
            request.setAttribute("error", "Phải 1 tg mới đc out");
            InforDAO i = new InforDAO();
            Informations in = i.get(Integer.parseInt(id));
            request.setAttribute("in", in);
            request.getRequestDispatcher("view/homeAInforUpdate.jsp").forward(request, response);
        } else {
            // Thực hiện xử lý lưu thông tin đăng ký phòng vào cơ sở dữ liệu
            InforDAO i = new InforDAO();
            Informations in = i.get(Integer.parseInt(id));

            in.setRoom_registration_date(Date.valueOf(rrd));
            in.setCancellation_date(Date.valueOf(cd));
            i.update(in);
            response.sendRedirect("homea");
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
