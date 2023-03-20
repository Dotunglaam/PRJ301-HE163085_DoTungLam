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
import java.util.logging.Level;
import java.util.logging.Logger;
import modol.Dormitories;
import modol.Rooms;

/**
 *
 * @author ADMIN
 */
public class RoomDAO extends DBContext {

    public ArrayList<Rooms> getAllRooms() {
        ArrayList<Rooms> room = new ArrayList<>();
        try {
            String sql = "select * from Rooms r join Dormitories d on r.dormitory_id = d.dormitory_id ";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo

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

                room.add(r);
            }
        } catch (SQLException e) {
        }

        return room;
    }

    public void insert(Rooms room) {
        PreparedStatement stm = null;
        try {
            String sql = "INSERT INTO [dbo].[Rooms]\n"
                    + "           ([name]\n"
                    + "           ,[current_people]\n"
                    + "           ,[price]\n"
                    + "           ,[dormitory_id]\n"
                    + "           ,[room_type]\n"
                    + "           ,[floor]\n"
                    + "           ,[status])"
                    + "            VALUES(?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, room.getName());
            stm.setInt(2, room.getCurrent_people());
            stm.setFloat(3, room.getPrice());
            stm.setInt(4, room.getDormitories().getDormitory_id());
            stm.setInt(5, room.getRoom_type());
            stm.setInt(6, room.getFloor());
            stm.setString(7, room.getStatus());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update(Rooms room) {
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE [dbo].[Rooms]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[current_people] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[dormitory_id] = ?\n"
                    + "      ,[room_type] = ?\n"
                    + "      ,[floor] = ?\n"
                    + "      ,[status] = ?\n"
                    + " WHERE room_id = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, room.getName());
            stm.setInt(2, room.getCurrent_people());
            stm.setFloat(3, room.getPrice());
            stm.setInt(4, room.getDormitories().getDormitory_id());
            stm.setInt(5, room.getRoom_type());
            stm.setInt(6, room.getFloor());
            stm.setString(7, room.getStatus());
            stm.setInt(7, room.getRoom_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(String id) {
        PreparedStatement stm = null;
        try {
            String sql = "DELETE from Rooms WHERE [room_id] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Rooms get(String id) {
        try {
            String sql = "SELECT *\n"
                    + "FROM Rooms \n"
                    + "WHERE [room_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Rooms r = new Rooms();
                r.setRoom_id(rs.getInt("room_id"));
                r.setName(rs.getString("name"));
                r.setCurrent_people(rs.getInt("current_people"));
                r.setPrice(rs.getInt("price"));

                Dormitories d = new Dormitories();
                d.setDormitory_id(rs.getInt("dormitory_id"));
                r.setDormitories(d);
                r.setRoom_type(rs.getInt("room_type"));
                r.setFloor(rs.getInt("floor"));
                r.setStatus(rs.getString("status"));
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    public static void main(String[] args) {
//        System.out.println(new RoomDAO().get("1"));
//    }
}
