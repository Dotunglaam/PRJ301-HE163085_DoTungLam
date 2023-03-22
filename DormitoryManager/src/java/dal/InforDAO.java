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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modol.Dormitories;
import modol.Informations;
import modol.Payments;
import modol.Rooms;
import modol.Users;

/**
 *
 * @author ADMIN
 */
public class InforDAO extends DBContext {
    public ArrayList<Informations> getListByPage(ArrayList<Informations> list,
            int start,int end){
        ArrayList<Informations> arr=new ArrayList<>();
        for(int i=start;i<end;i++){
            arr.add(list.get(i));
        }
        return arr;
    }


    public ArrayList<Informations> getAllInfor() {
        ArrayList<Informations> infor = new ArrayList<>();
        try {
            String sql = "select * from Informations i, Rooms r, Users u, Payments p\n"
                    + "                    where i.room_id =r.room_id and i.user_id = u.user_id and i.payment_id = p.payment_id";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo
                Informations in = new Informations();
                in.setIn_id(rs.getInt("in_id"));

                Users u = new Users();
                u.setUser_id(rs.getInt("user_id"));
                u.setFull_name(rs.getString("full_name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole_id(rs.getInt("role_id"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setPhone(rs.getString("phone"));
                in.setUsers(u);

                Rooms r = new Rooms();
                r.setRoom_id(rs.getInt("room_id"));
                r.setName(rs.getString("name"));
                r.setCurrent_people(rs.getInt("current_people"));
                r.setPrice(rs.getFloat("price"));
                Dormitories d = new Dormitories();
                d.setDormitory_id(rs.getInt("dormitory_id"));
                d.setName(rs.getString("name"));
                r.setDormitories(d);
                r.setRoom_type(rs.getInt("room_type"));
                r.setFloor(rs.getInt("floor"));
                r.setStatus(rs.getString("status"));
                in.setRooms(r);

                Payments p = new Payments();
                p.setPayment_id(rs.getInt("payment_id"));
                p.setUsers(u);
                p.setRooms(r);
                p.setAmount(rs.getFloat("amount"));
                p.setPayment_date(rs.getDate("payment_date"));
                p.setStatus(rs.getString("status"));
                in.setPayments(p);
                in.setRoom_registration_date(rs.getDate("room_registration_date"));
                in.setCancellation_date(rs.getDate("cancellation_date"));
                infor.add(in);
            }
        } catch (SQLException e) {
        }
        return infor;
    }

    public void update(Informations infor) {
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE [dbo].[Informations]\n"
                    + "   SET [room_registration_date] = ?\n"
                    + "      ,[cancellation_date] = ?\n"
                    + " WHERE in_id = ?";
            stm = connection.prepareStatement(sql);
            stm.setDate(1, infor.getRoom_registration_date());
            stm.setDate(2, infor.getCancellation_date());
            stm.setInt(3, infor.getIn_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InforDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(InforDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(InforDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(String id) {
        PreparedStatement stm = null;
        try {
            String sql = "DELETE from Informations WHERE [in_id] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InforDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Informations getFollowUserID(int id) {
        try {
            String sql = "select * from Informations i, Rooms r, Users u, Payments p           \n"
                    + "where i.room_id =r.room_id and i.user_id = u.user_id and i.payment_id = p.payment_id and i.user_id = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Informations in = new Informations();
                
                Users u = new Users();
                u.setUser_id(rs.getInt("user_id"));
                u.setFull_name(rs.getString("full_name"));
                u.setUsername(rs.getString("username"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setPhone(rs.getString("phone"));
                in.setUsers(u);

                Rooms r = new Rooms();
                r.setName(rs.getString("name"));
                r.setPrice(rs.getFloat("price"));
                Dormitories d = new Dormitories();
                d.setName(rs.getString("name"));
                r.setDormitories(d);
                r.setFloor(rs.getInt("floor"));
                r.setStatus(rs.getString("status"));
                in.setRooms(r);

                Payments p = new Payments();
                p.setAmount(rs.getFloat("amount"));
                p.setPayment_date(rs.getDate("payment_date"));
                p.setStatus(rs.getString("status"));
                in.setPayments(p);
                in.setRoom_registration_date(rs.getDate("room_registration_date"));
                in.setCancellation_date(rs.getDate("cancellation_date"));
                return in;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InforDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Informations get(int id) {
        try {
            String sql = "select i.in_id,i.room_registration_date,i.cancellation_date from Informations i, Rooms r, Users u , Payments p\n"
                    + "where i.room_id =r.room_id and i.user_id = u.user_id and i.payment_id = p.payment_id  \n"
                    + "and [in_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Informations in = new Informations();
                in.setIn_id(rs.getInt("in_id"));
                in.setRoom_registration_date(rs.getDate("room_registration_date"));
                in.setCancellation_date(rs.getDate("cancellation_date"));
                return in;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InforDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Informations> search(String txt) {
        ArrayList<Informations> infor = new ArrayList<>();
        try {
            String sql = "select * from Informations i join Rooms r on i.room_id =r.room_id \n" +
"							join Users u  on i.user_id = u.user_id \n" +
"							join Payments p on i.payment_id = p.payment_id \n" +
"							where u.full_name like ? or r.name like ?";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"%" + txt + "%");
            ps.setString(2,"%" + txt + "%");
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo
                Informations in = new Informations();
                in.setIn_id(rs.getInt("in_id"));

                Users u = new Users();
                u.setUser_id(rs.getInt("user_id"));
                u.setFull_name(rs.getString("full_name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole_id(rs.getInt("role_id"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setPhone(rs.getString("phone"));
                in.setUsers(u);

                Rooms r = new Rooms();
                r.setRoom_id(rs.getInt("room_id"));
                r.setName(rs.getString("name"));
                r.setCurrent_people(rs.getInt("current_people"));
                r.setPrice(rs.getFloat("price"));
                Dormitories d = new Dormitories();
                d.setDormitory_id(rs.getInt("dormitory_id"));
                d.setName(rs.getString("name"));
                r.setDormitories(d);
                r.setRoom_type(rs.getInt("room_type"));
                r.setFloor(rs.getInt("floor"));
                r.setStatus(rs.getString("status"));
                in.setRooms(r);

                Payments p = new Payments();
                p.setPayment_id(rs.getInt("payment_id"));
                p.setUsers(u);
                p.setRooms(r);
                p.setAmount(rs.getFloat("amount"));
                p.setPayment_date(rs.getDate("payment_date"));
                p.setStatus(rs.getString("status"));
                in.setPayments(p);
                in.setRoom_registration_date(rs.getDate("room_registration_date"));
                in.setCancellation_date(rs.getDate("cancellation_date"));
                infor.add(in);
            }
        } catch (SQLException e) {
        }
        return infor;
    }
    public static void main(String[] args) {
        System.out.println(new InforDAO().getFollowUserID(3));
    }
}
