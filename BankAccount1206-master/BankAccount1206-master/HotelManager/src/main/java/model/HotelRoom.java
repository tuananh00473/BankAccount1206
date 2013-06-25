package model;

import controller.DBController;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/20/13
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class HotelRoom implements Serializable {

    public static final int LOW = 0;
    public static final int MEDIUM = 1;
    public static final int HIGH = 2;
    public static final int SUPER = 3;

    private int roomID;
    private int roomType;
    private String roomDescription;

    public HotelRoom() {
    }

    public HotelRoom(int roomType, String roomDescription) {
        this.roomID = getIdIncrement();
        this.roomType = roomType;
        this.roomDescription = roomDescription;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof HotelRoom){
            HotelRoom hotelRoom = (HotelRoom)o;
            if(hotelRoom.getRoomType() == (HotelRoom.MEDIUM) &&  hotelRoom.getRoomDescription().equals("description"))
                return true;
        }
        return false;
    }

    private int getIdIncrement() {
        int currentID = new DBController().getMaxID();
        return currentID + 1;
    }
}

