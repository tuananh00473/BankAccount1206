package controller;

import model.HotelRoom;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/20/13
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBController {
    public int getMaxID() {
        // insert code search max ID of table in here then return value;
        return 1;
    }

    public HotelRoom getRoom(int roomID) {
        // search in database find the room has id as roomID then return it
        return new HotelRoom(HotelRoom.MEDIUM, "description");
    }
}
