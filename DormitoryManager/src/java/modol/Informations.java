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
    private Date room_registration_date;
    private Date cancellation_date;

    public Informations() {
    }

    public Informations(int in_id, Users users, Rooms rooms, Payments payments, Date room_registration_date, Date cancellation_date) {
        this.in_id = in_id;
        this.users = users;
        this.rooms = rooms;
        this.payments = payments;
        this.room_registration_date = room_registration_date;
        this.cancellation_date = cancellation_date;
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
        return room_registration_date;
    }

    public void setRoom_registration_date(Date room_registration_date) {
        this.room_registration_date = room_registration_date;
    }

    public Date getCancellation_date() {
        return cancellation_date;
    }

    public void setCancellation_date(Date cancellation_date) {
        this.cancellation_date = cancellation_date;
    }

    @Override
    public String toString() {
        return "Informations{" + "in_id=" + in_id + ", users=" + users + ", rooms=" + rooms + ", payments=" + payments + ", room_registration_date=" + room_registration_date + ", cancellation_date=" + cancellation_date + '}';
    }
    
    
}
