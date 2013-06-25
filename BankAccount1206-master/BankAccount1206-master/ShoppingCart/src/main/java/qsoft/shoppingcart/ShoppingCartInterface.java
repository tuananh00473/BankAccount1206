package qsoft.shoppingcart;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/23/13
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;

public interface ShoppingCartInterface {
    /**
     * Add this many of this item to the
     * shopping cart.
     */

    public void addItems(Item anItem, int quantity);
    /**
     * Delete this many of this item from the
     * shopping cart
     */
    public void deleteItems(Item anItem, int quantity);
    /**
     * Count of all items in the cart
     * (that is, all items x qty each)
     */
    public int itemCount();
    /**
     * Return Iterator of all items
     * (see Java Collection’s doc)
     */
    public Iterator iterator();
}
