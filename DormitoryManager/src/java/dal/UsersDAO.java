package dal;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modol.Users;

/**
 *
 * @author ADMIN
 */
public class UsersDAO extends DBContext {

    public Users getUsers(String user, String pass) {
        Users account = null;
        try {
            String sql = "SELECT * FROM Users\n"
                    + "                     WHERE username = ?  AND password = ?";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo
                account = new Users(rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("user_id"),
                        rs.getString("full_name"),
                        rs.getInt("role_id"),
                        rs.getBoolean("gender"),
                        rs.getDate("dob"),
                        rs.getString("phone"));
            }
        } catch (SQLException e) {
        }

        return account;
    }

    public Users checkAccountExist(String username) {
        try {
            String sql = "select * from Users\n"
                    + "where [username] = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Users account = new Users();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                return account;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void createAccount(Users u) {
        try {
            String sql = "INSERT INTO  [dbo].[Users]\n"
                    + "           ([username]\n"
                    + "           ,[password]\n"
                    + "           ,[full_name]\n"
                    + "           ,[role_id]\n"
                    + "           ,[gender]\n"
                    + "           ,[dob]\n"
                    + "           ,[phone]\n)"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUsername());
            stm.setString(2, u.getPassword());
            stm.setString(3, u.getFull_name());
            stm.setInt(4, u.getRole_id());
            stm.setBoolean(5, u.isGender());
            stm.setDate(6, u.getDob());
            stm.setString(7, u.getPhone());
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Users> getAllUser() {
        ArrayList<Users> user = new ArrayList<>();
        try {
            String sql = "SELECT [user_id]\n"
                    + "      ,[username]\n"
                    + "      ,[full_name]\n"
                    + "      ,[role_id]\n"
                    + "      ,[gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[phone]\n"
                    + "  FROM [dbo].[Users]";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo

                Users u = new Users();
                u.setUser_id(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setFull_name(rs.getString("full_name"));
                u.setRole_id(rs.getInt("role_id"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setPhone(rs.getString("phone"));
                user.add(u);
            }
        } catch (SQLException e) {
        }

        return user;
    }

    public void update(Users user) {
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [role_id] = ?\n"
                    + " WHERE user_id = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, user.getRole_id());
            stm.setInt(2, user.getUser_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(String id) {
        PreparedStatement stm = null;
        try {
            String sql = "DELETE from Users WHERE [user_id] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Users get(int id) {
        try {
            String sql = "SELECT *\n"
                    + "FROM Users \n"
                    + "WHERE [user_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Users u = new Users();
                u.setUser_id(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setFull_name(rs.getString("full_name"));
                u.setRole_id(rs.getInt("role_id"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setPhone(rs.getString("phone"));
                
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new UsersDAO().get(1));
    }
}
