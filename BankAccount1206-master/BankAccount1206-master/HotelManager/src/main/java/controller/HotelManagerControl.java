package controller;

import dao.HotelManagerDao;
import model.HotelRoom;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/20/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class HotelManagerControl {
    public static HotelManagerDao hotelManagerDao;

    public void addRoom(HotelRoom hotelRoom){
        hotelManagerDao.addRoom(hotelRoom);
    }
}
