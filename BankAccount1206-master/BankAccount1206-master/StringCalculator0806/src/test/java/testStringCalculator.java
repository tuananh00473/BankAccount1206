import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/8/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class testStringCalculator {
    @Test
    public void testShouldReturn0WithEmptyString(){
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testShouldReturnNumber(){
        Assert.assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testShouldReturnSumOfNumber(){
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testShouldReturnSumOfNumberWithRegex(){
        Assert.assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testShouldReturnSumOfNumberWithDelimiter(){
        Assert.assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testShouldReturnMessageWithNegative(){
        try{
            Assert.assertEquals(0, StringCalculator.add("-1,2"));
            fail("Runtime Exception");
        }catch (RuntimeException re){
            Assert.assertEquals("Negative Exception with -1", re.getMessage());
        }
    }

    @Test
    public void testShouldReturnMessageWithManyNegative(){
        try{
            Assert.assertEquals(0, StringCalculator.add("-1,-2,3,4,-5"));
            fail("Runtime Exception");
        }catch (RuntimeException re){
            Assert.assertEquals("Negative Exception with -1 -2 -5", re.getMessage());
        }
    }

    @Test
    public void testShouldNotAddNumberMoreThanThousand(){
        Assert.assertEquals(2, StringCalculator.add("2,1001"));
    }

    @Test
    public void testShouldReturnSumWithLongerDelimiter(){
        Assert.assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testShouldReturnSumWithManyDelimiter(){
        Assert.assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testShouldReturnSumWithManyLongerDelimiter(){
        Assert.assertEquals(6, StringCalculator.add("//[***][%%%]\n1***2%%%3"));
    }
}
