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
}
