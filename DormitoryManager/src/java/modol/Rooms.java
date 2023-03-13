/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modol;

/**
 *
 * @author ADMIN
 */
public class Rooms {
    private int room_id;
    private String name;
    private int current_people;
    private float price;
    private Dormitories dormitories;
    private int room_type;
    private int floor;
    private String status;

    public Rooms() {
    }

    public Rooms(int room_id, String name, int current_people, float price, Dormitories dormitories, int room_type, int floor, String status) {
        this.room_id = room_id;
        this.name = name;
        this.current_people = current_people;
        this.price = price;
        this.dormitories = dormitories;
        this.room_type = room_type;
        this.floor = floor;
        this.status = status;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrent_people() {
        return current_people;
    }

    public void setCurrent_people(int current_people) {
        this.current_people = current_people;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Dormitories getDormitories() {
        return dormitories;
    }

    public void setDormitories(Dormitories dormitories) {
        this.dormitories = dormitories;
    }

    public int getRoom_type() {
        return room_type;
    }

    public void setRoom_type(int room_type) {
        this.room_type = room_type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rooms{" + "room_id=" + room_id + ", name=" + name + ", current_people=" + current_people + ", price=" + price + ", dormitories=" + dormitories + ", room_type=" + room_type + ", floor=" + floor + ", status=" + status + '}';
    }
    
    
}
