import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/7/13
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCalculator {
    @Test
    public void testShouldReturn0WithEmptyString(){
       assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testShouldReturnNumber(){
       assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testShouldReturnSumOfNumber(){
       assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testShouldReturnSumOfNumberWithNewLine(){
       assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testShouldReturnSumOfNumberWithDelimiter(){
       assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testShouldReturnMessageWithNegative(){
        try{
            assertEquals(0, StringCalculator.add("-1,2"));
            fail("Negative Exception");
        }catch (RuntimeException re){
            assertEquals("Negative Exception With -1 ", re.getMessage());
        }
    }

    @Test
    public void testShouldReturnMessageWithManyNegative(){
        try{
            assertEquals(0, StringCalculator.add("-1,-2,3,4,-6"));
            fail("Negative Exception");
        }catch (RuntimeException re){
            assertEquals("Negative Exception With -1 -2 -6 ", re.getMessage());
        }
    }

    @Test
    public void testShouldNotAddWithNumberMoreThanThousand(){
        assertEquals(2, StringCalculator.add("2,1001"));
    }

    @Test
    public void testShouldReturnSumWithLongerDelimiter(){
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testShouldReturnSumWithManyDelimiter(){
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testShouldReturnSumWithManyLongerDelimiter(){
        assertEquals(6, StringCalculator.add("//[***][%%%]\n1***2%%%3"));
    }
}
