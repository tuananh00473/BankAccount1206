package qsoft.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/23/13
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCart implements ShoppingCartInterface {
    List<Item> listItem = new ArrayList<Item>();
    @Override
    public void addItems(Item anItem, int quantity ) {
        if(quantity<=0){
            //do nothing.
        }else{
            for (int i=0; i<quantity; i++){
                listItem.add(anItem);
            }
        }
    }

    @Override
    public void deleteItems(Item anItem, int quantity) {
        if(quantity <= 0){
            //do nothing
        }
        for(int i=0; i<quantity; i++){
            try{
                listItem.remove(anItem);
            }catch (Exception e){
                // do nothing
            }
        }
    }

    @Override
    public int itemCount() {
        return listItem.size();
    }

    @Override
    public Iterator iterator() {
        return listItem.iterator();
    }
}
