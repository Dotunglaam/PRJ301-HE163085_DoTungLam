/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modol;

/**
 *
 * @author ADMIN
 */
public class Dormitories {
    private int dormitory_id;
    private String name;

    public Dormitories() {
    }

    public Dormitories(int dormitory_id, String name) {
        this.dormitory_id = dormitory_id;
        this.name = name;
    }

    public int getDormitory_id() {
        return dormitory_id;
    }

    public void setDormitory_id(int dormitory_id) {
        this.dormitory_id = dormitory_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dormitories{" + "dormitory_id=" + dormitory_id + ", name=" + name + '}';
    }
    
}
