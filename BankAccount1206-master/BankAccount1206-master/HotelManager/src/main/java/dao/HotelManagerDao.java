package dao;

import controller.DBController;
import model.HotelRoom;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/20/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class HotelManagerDao {
    public HotelRoom addRoom(HotelRoom hotelRoom) {
        return null;
    }

    public static HotelRoom getRoom(int roomID) {
        HotelRoom hotelRoom = new DBController().getRoom(roomID);
        return hotelRoom;
    }
}
