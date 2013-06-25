import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/5/13
 * Time: 11:24 PM
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
    public void testShouldReturnSumOfStringWithRegex(){
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testShouldReturnSumValueWithNewLineDigit(){
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testShouldReturnValueWithDoubleRegex(){
        assertEquals(1, StringCalculator.add("1,\n"));
    }

    @Test
    public void testShouldReturnSumWithOneDelimiter(){
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testShould(){
        assertEquals(6, StringCalculator.add("//;\n1;2,3"));
    }

    @Test
    public void testShouldReturnMessageWithOneNegative(){
        try{
            assertEquals(0, StringCalculator.add("-1,2"));
            fail("Negative Exception");
        }catch(RuntimeException re){
            System.out.println(re.getMessage());
            assertEquals("Negative Exception with -1 ", re.getMessage());
        }
    }

    @Test
    public void testShouldReturnMessageWithTwoNegative(){
        try{
            assertEquals(0, StringCalculator.add("-1,-2,3,-4"));
            fail("Negative Exception");
        }catch(RuntimeException re){
            System.out.println(re.getMessage());
            assertEquals("Negative Exception with -1 -2 -4 ", re.getMessage());
        }
    }

    @Test
    public void testShouldReturnNotNumberMoreThanThousand(){
        assertEquals(2, StringCalculator.add("2,1001"));
    }

    @Test
    public void testShouldReturnSumWithDelimiterLonger(){
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testShouldReturnSumWithManyDelimiter(){
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }
}
