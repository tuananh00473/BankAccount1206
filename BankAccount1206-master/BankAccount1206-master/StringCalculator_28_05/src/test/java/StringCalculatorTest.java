/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/27/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */

import junit.framework.Assert;
import org.junit.Test;

import stringcalculator.StringCalculator;

public class StringCalculatorTest {
    @Test
    public void testShouldReturn0WithEmptyString(){
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testShouldReturnANumberWithAStringNumber(){
        Assert.assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testShouldReturnSumOfTwoNumber(){
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }
    @Test
    public void testShouldReturn7(){
        Assert.assertEquals(7, StringCalculator.add("2\n3.2"));
    }

    @Test
    public void testShouldReturn6(){
        Assert.assertEquals(6, StringCalculator.add("1,\\\n,3.2"));
    }
}
