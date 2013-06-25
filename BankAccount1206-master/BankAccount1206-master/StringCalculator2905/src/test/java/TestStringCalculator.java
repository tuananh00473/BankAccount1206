import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/29/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCalculator {
    @Test
    public void testShouldReturn0(){
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testShouldReturn1(){
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(1, StringCalculator.add("1."));
        assertEquals(1, StringCalculator.add("1,\n"));
    }

    @Test
    public void testShouldReturn5(){
        assertEquals(5, StringCalculator.add("2,3"));
    }

    @Test
    public void testShouldReturn6(){
        assertEquals(6, StringCalculator.add("1,\n2,3"));
        assertEquals(6, StringCalculator.add("//[***]\\n1***2***3"));
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testShouldReturn3(){
        assertEquals(3, StringCalculator.add("//;\\n1;2"));
    }

    @Test
    public void testShouldReturn23(){
        assertEquals(23, StringCalculator.add("//;\\n23,*"));
    }

    @Test
    public void testShouldReturn25(){
        assertEquals(25, StringCalculator.add("//2;\\n23,*"));
    }
}
