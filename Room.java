package pl.edu.amu.wmi.s474155;

import java.io.Serializable;

public class Room implements Serializable {

    private int roomNumber;
    private int capacity;
    private int price;

    public Room(int roomNumber, int capacity, int price){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    public int getRoomNumber(){
        return roomNumber;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }

    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }

}
