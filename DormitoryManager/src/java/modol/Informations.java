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
public class Informations {

    private int in_id;
    private Users users;
    private Rooms rooms;
    private Payments payments;
    private Date Room_registration_date;
    private Date Cancellation_date;

    public Informations() {
    }

    public int getIn_id() {
        return in_id;
    }

    public void setIn_id(int in_id) {
        this.in_id = in_id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    public Date getRoom_registration_date() {
        return Room_registration_date;
    }

    public void setRoom_registration_date(Date Room_registration_date) {
        this.Room_registration_date = Room_registration_date;
    }

    public Date getCancellation_date() {
        return Cancellation_date;
    }

    public void setCancellation_date(Date Cancellation_date) {
        this.Cancellation_date = Cancellation_date;
    }

    @Override
    public String toString() {
        return "Informations{" + "in_id=" + in_id + ", users=" + users + ", rooms=" + rooms + ", payments=" + payments + ", Room_registration_date=" + Room_registration_date + ", Cancellation_date=" + Cancellation_date + '}';
    }
    
}
