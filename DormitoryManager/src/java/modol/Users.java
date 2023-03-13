/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modol;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Users {

    private String username;
    private String password;
    private int user_id;
    private String full_name;
    private int role_id;
    private boolean gender;
    private Date dob;
    private String phone;

    public Users() {
    }

    public Users(String username, String password, int user_id, String full_name, int role_id, boolean gender, Date dob, String phone) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;
        this.full_name = full_name;
        this.role_id = role_id;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Users{" + "username=" + username + ", password=" + password + ", user_id=" + user_id + ", full_name=" + full_name + ", role_id=" + role_id + ", gender=" + gender + ", dob=" + dob + ", phone=" + phone + '}';
    }
    
    
    
}
