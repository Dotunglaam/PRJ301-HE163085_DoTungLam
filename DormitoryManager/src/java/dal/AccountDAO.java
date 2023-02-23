package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modol.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends DBContext {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public Account getAccount(String user, String pass) {
        Account account = null;
        try {
            String sql = "SELECT username, password FROM Account\n"
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

                String username = rs.getString("username");
                String Password = rs.getString("password");

                account = new Account(username, Password);
            }
        } catch (SQLException e) {
        }

        return account;
    }

    public Account checkAccountExist(String username) {
        try {
            String sql = "select * from Account\n"
                    + "where [username] = ?\n";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                return account;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void createAccount(String username, String password, String displayname) {
        try {
            String sql = "INSERT INTO [Account]\n"
                    + "           ([username]\n"
                    + "           ,[password]\n"
                    + "           ,[displayname])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, displayname);
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        System.out.println(new AccountDAO().getAccount("lamdt", "123"));
//    }

}
