import controller.HotelManagerControl;
import dao.HotelManagerDao;
import model.HotelRoom;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/20/13
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestHotelManager {

    private static int roomID = 1;

    @Mock
    HotelManagerDao mockDao = mock(HotelManagerDao.class);

    @Before
    public void setUp(){
        reset(mockDao);
        HotelManagerControl.hotelManagerDao = mockDao;
    }

    @Test
    public void testAddRoom(){
        HotelRoom hotelRoom = new HotelRoom(HotelRoom.MEDIUM, "description");

        ArgumentCaptor<HotelRoom> argumentCaptor = ArgumentCaptor.forClass(HotelRoom.class);
        verify(mockDao, times(1)).addRoom(argumentCaptor.capture());

        assertEquals(HotelRoom.MEDIUM, argumentCaptor.getValue().getRoomType(), 0.0000001);
        assertEquals("description", argumentCaptor.getValue().getRoomDescription());

    }
}
