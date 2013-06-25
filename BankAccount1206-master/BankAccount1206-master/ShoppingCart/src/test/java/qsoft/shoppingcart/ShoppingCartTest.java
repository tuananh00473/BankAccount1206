package qsoft.shoppingcart;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/23/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartTest{

    protected ShoppingCart shoppingCart = new ShoppingCart();
    protected Item item = new Item("TV", 10000000);

    @Test
    public void should_have_no_item(){
        assertEquals(0, shoppingCart.itemCount());
    }

    @Test
    public void should_increment_itemcount(){
        int count = shoppingCart.itemCount();
        shoppingCart.addItems(item, 3);
        assertEquals(count + 3, shoppingCart.itemCount());
    }

    @Test
    public void should_decrement_itemcount(){
        int count = shoppingCart.itemCount();
        shoppingCart.addItems(item, 3);
        shoppingCart.deleteItems(item, 1);
        assertEquals(count + 2, shoppingCart.itemCount());
    }

    @Test
    public void should_cannot_decrement_itemcount(){
        int count = shoppingCart.itemCount();
        shoppingCart.addItems(item, 1);
        shoppingCart.deleteItems(item, 3);
        assertEquals(0, shoppingCart.itemCount());
    }
}
