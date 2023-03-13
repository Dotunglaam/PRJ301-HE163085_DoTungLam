/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modol.Dormitories;
import modol.Payments;
import modol.Rooms;
import modol.Users;

/**
 *
 * @author ADMIN
 */
public class PaymentDAO extends DBContext {

//    public Users getUserById(int id) {
//        try {
//            String sql = "select * from Users where user_id = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Users u = new Users(rs.getString("username"),
//                        rs.getString("password"),
//                        rs.getInt("user_id"),
//                        rs.getString("full_name"),
//                        rs.getInt("role_id"),
//                        rs.getBoolean("gender"),
//                        rs.getDate("dob"),
//                        rs.getString("phone"));
//                return u;
//            }
//        } catch (SQLException e) {
//
//        }
//        return null;
//    }

    public ArrayList<Payments> getAllPayments() {
        ArrayList<Payments> payment = new ArrayList<>();
        try {
            String sql = "select * "
                    + " from Payments p , Rooms r , Users u "
                    + "where p.room_id = r.room_id and p.user_id = u.user_id";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo
                Payments p = new Payments();
                p.setPayment_id(rs.getInt("payment_id"));

                Users u = new Users();
                u.setUser_id(rs.getInt("user_id"));
                u.setFull_name(rs.getString("full_name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole_id(rs.getInt("role_id"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setPhone(rs.getString("phone"));
                p.setUsers(u);
                
                Rooms r = new Rooms();
                r.setRoom_id(rs.getInt("room_id"));
                r.setName(rs.getString("name"));
                r.setCurrent_people(rs.getInt("current_people"));
                r.setPrice(rs.getInt("price"));
                Dormitories d = new Dormitories();
                d.setDormitory_id(rs.getInt("dormitory_id"));
                d.setName(rs.getString("name"));
                r.setDormitories(d);
                r.setRoom_type(rs.getInt("room_type"));
                r.setFloor(rs.getInt("floor"));
                r.setStatus(rs.getString("status"));
                
                p.setRooms(r);
                p.setAmount(rs.getFloat("amount"));
//                p.setUsers(u);
//                p.setRooms(r);
                p.setPayment_date(rs.getDate("payment_date"));
                p.setStatus(rs.getString("status"));

                payment.add(p);
            }
        } catch (SQLException e) {
        }

        return payment;
    }

    public static void main(String[] args) {
        System.out.println(new PaymentDAO().getAllPayments());
    }
}
