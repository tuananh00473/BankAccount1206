import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/6/13
 * Time: 1:43 PM
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
    public void testShouldReturnSumValue(){
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testShouldReturnSumValueWithLongerRegex(){
        Assert.assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testShouldReturnSumValueWithAnotherRegex(){
        Assert.assertEquals(6, StringCalculator.add("1\n2;3"));
    }

    @Test
    public void testShouldReturnSumValueDelimiter(){
        Assert.assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testShouldReturnSumWithManyRegex(){
        Assert.assertEquals(6, StringCalculator.add("//;\n1;2,3"));
    }

    @Test
    public void testShouldReturnMessageWithNegative(){
        try{
            Assert.assertEquals(0, StringCalculator.add("-1,2"));
            fail("Runtime Exception");
        }catch (RuntimeException re){
            assertEquals("Negative Exception With -1 ", re.getMessage());
        }

    }

    @Test
    public void testShouldReturnMessageWithMoreNegative(){
        try{
            Assert.assertEquals(0, StringCalculator.add("-1,-2,3,-5"));
            fail("Runtime Exception");
        }catch (RuntimeException re){
            assertEquals("Negative Exception With -1 -2 -5 ", re.getMessage());
        }

    }

    @Test
    public void testShouldReturnNullWithNumberMoreThan1000(){
        Assert.assertEquals(2, StringCalculator.add("//;\n2;1001"));
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
