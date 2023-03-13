package dal;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                account = new Users(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getString(8));
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

//    public static void main(String[] args) {
//        System.out.println(new UsersDAO().getAccount("lamdt", "123"));
//    }
}
