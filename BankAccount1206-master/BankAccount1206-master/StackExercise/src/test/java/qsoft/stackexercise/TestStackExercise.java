package qsoft.stackexercise;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/23/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class TestStackExercise {
    protected StackExercise stackExercise;

    @Test
    public void testNewStackIsEmpty(){
        assertTrue(stackExercise.isEmpty());
        assertEquals(0, stackExercise.getSize());
    }

    @Test
    public void testPushesToEmptyStack() {
        int numberOfPushes = 6;
        for (int i = 0; i < numberOfPushes; i++) {
            stackExercise.push("zzz");
        }
        assertFalse(stackExercise.isEmpty());
        assertEquals(stackExercise.getSize(), numberOfPushes);
    }

    @Test
    public void testPushThenPop() {
        String message = "hello";
        stackExercise.push(message);
        assertEquals(stackExercise.pop(), message);
    }

    @Test
    public void testPushThenTop() {
        String message = "hello";
        stackExercise.push(message);
        int size = stackExercise.getSize();
        assertEquals(stackExercise.top(), message);
        assertEquals(stackExercise.getSize(), size);
    }

    @Test
    public void popFormEmptyStack(){
        assertTrue(stackExercise.isEmpty());
        stackExercise.pop();
    }

}
