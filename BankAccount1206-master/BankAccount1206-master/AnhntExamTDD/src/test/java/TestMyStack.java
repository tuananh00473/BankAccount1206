import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/18/13
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestMyStack {

    protected MyStack myStack = new MyStack();

    @Test
    public void testOpenEmptyStack(){
        assertTrue(myStack.isEmpty());
        assertEquals(0, myStack.getSize());
    }

    @Test
    public void testShouldReturnSizeIsOne(){
        assertTrue(myStack.isEmpty());

        Object obj = new String("object");
        myStack.push(obj);

        assertFalse(myStack.isEmpty());
        assertEquals(1, myStack.getSize());
    }

    @Test
    public void testShouldReturnSizeIncrementWhenPush(){
        assertTrue(myStack.isEmpty());
        int size = 5;
        for(int i=0; i<size; i++){
             myStack.push("" + i);
        }

        assertEquals(size, myStack.getSize());
        Object obj = new String("object");
        myStack.push(obj);

        assertEquals(size + 1, myStack.getSize());
    }

    @Test
    public void testShouldReturnNullWhenTopEmptyStack(){
        assertTrue(myStack.isEmpty());
        assertEquals(null, myStack.top());
    }

    @Test
    public void testShouldReturnElementJustPushWhenTop(){
        Object obj = new String("object");
        myStack.push(obj);
        assertEquals(obj, myStack.top());
    }

    @Test
    public void testShouldReturnMessageWhenPopEmptyStack(){
        assertTrue(myStack.isEmpty());
        try{
            myStack.pop();
            assertEquals(-1, myStack.getSize());
            fail("StackEmptyException");

        }catch (StackEmptyException see){
            assertEquals("Can't pop empty stack.", see.getMessage());
        }
    }

    @Test
    public void testShouldDecrementSizeWhenPop(){
        assertTrue(myStack.isEmpty());
        int size = 5;
        for(int i=0; i<size; i++){
            myStack.push("" + i);
        }

        assertEquals(size, myStack.getSize());
        myStack.pop();

        assertEquals(size - 1, myStack.getSize());
    }

    @Test
    public void testShouldShowStackEmptyWhenNotHaveElement(){
        myStack.push("abc");
        myStack.pop();
        assertEquals(0, myStack.getSize());
    }

    @Test
    public void testPushElementPThenPopShouldReturnPOnly(){
        assertTrue(myStack.isEmpty());
        int size = 5;
        for(int i=0; i<size; i++){
            myStack.push("" + i);
        }

        assertEquals(size, myStack.getSize());
        Object obj = new String("object");
        myStack.push(obj);

        assertEquals(myStack.top(), myStack.pop());
    }

    @Test
    public void testShouldReturnReverseOfInputElement(){
        assertTrue(myStack.isEmpty());
        int size = 5;
        for(int i=0; i<size; i++){
            myStack.push("" + i);
        }

        while (!myStack.isEmpty()){
            System.out.println(myStack.pop().toString());
        }
    }
}
