import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/18/13
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyStack {

    private LinkedList<Object> myStack = new LinkedList<Object>();

    public boolean isEmpty() {
        return myStack.isEmpty();
    }

    public int getSize() {
        return myStack.size();
    }

    public void push(Object obj) {
        myStack.addFirst(obj);
    }

    public Object top() {
        Object obj = null;
        if(!myStack.isEmpty()){
            obj = myStack.getFirst();
        }
        return obj;
    }

    public Object pop() {
        Object obj = null;
        if(!myStack.isEmpty()){
            obj = myStack.getFirst();
            myStack.removeFirst();
            if(myStack.isEmpty()){
                System.out.println("Stack Empty!");
            }
        }else{
            throw new StackEmptyException("Can't pop empty stack.") ;
        }
        return obj;
    }
}
