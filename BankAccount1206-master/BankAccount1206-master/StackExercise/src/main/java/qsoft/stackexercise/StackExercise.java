package qsoft.stackexercise;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/23/13
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class StackExercise implements StackInterface {
    private LinkedList<Object> list = new LinkedList<Object>();
    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public void push(Object item) {
        list.addFirst(item);
    }

    @Override
    public Object top() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize(){
        return list.size();
    }
}
