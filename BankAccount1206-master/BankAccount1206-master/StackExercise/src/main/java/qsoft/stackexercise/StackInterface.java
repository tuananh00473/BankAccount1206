package qsoft.stackexercise;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/23/13
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StackInterface {
    /**
     * Return and remove the most recent item from
     * the top of the stack.
     * Throws StackEmptyException
     * if the stack is empty
     */
    public Object pop();
    /**
     * Add an item to the top of the stack.
     */
    public void push(Object item);
    /**
     * Return but do not remove the most recent
     * item from the top of the stack.
     * Throws StackEmptyException
     * if the stack is empty
     */
    public Object top();
    /**
     * Returns true if the stack is empty.
     */
    public boolean isEmpty();
}
