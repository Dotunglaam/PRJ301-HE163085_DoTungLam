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

/**
 *
 * @author ADMIN
 */
public class DormDAO extends DBContext {

    public ArrayList<Dormitories> getDorm() {
        ArrayList<Dormitories> dorm = new ArrayList<>();
        try {
            String sql = "select * from Dormitories";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo
                Dormitories a = new Dormitories();
                a.setDormitory_id(rs.getInt("dormitory_id"));
                a.setName(rs.getString("name"));
                dorm.add(a);
            }
        } catch (SQLException e) {
        }

        return dorm;
    }
    public void insert(Dormitories dorm) {
        PreparedStatement stm = null;
        try {
            String sql = "INSERT INTO Dormitories(name) VALUES(?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, dorm.getName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void update(Dormitories dorm) {
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE [Dormitories]\n"
                    + "   SET [name] = ?\n"
                    + " WHERE [dormitory_id] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, dorm.getName());
            stm.setInt(2, dorm.getDormitory_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public void delete(String id ) {
        PreparedStatement stm = null;
        try {
            String sql = "DELETE from Dormitories WHERE [dormitory_id] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public Dormitories checkDormExist(String name) {
        try {
            String sql = "select * from Dormitories\n"
                    + "where [name] = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Dormitories dorm = new Dormitories();
                dorm.setName(rs.getString("name"));
                
                return dorm;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Dormitories get(String id) {
        try {
            String sql = "SELECT *\n"
                    + "FROM Dormitories \n"
                    + "WHERE [dormitory_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Dormitories dorm = new Dormitories(rs.getInt(1),
                rs.getString(2));
                return dorm;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DormDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}