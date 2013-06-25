import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/30/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCalculator {
    @Test
    public void testShouldReturnWithEmptyString(){
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testShouldReturnNumberWithNoDelimiter(){
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testStringHasOneDelimiter(){
        assertEquals(5, StringCalculator.add("2,3"));
    }

    @Test
    public void testStringHasOneOtherDelimiter(){
        assertEquals(5, StringCalculator.add("2;3"));
    }

    @Test
    public void testStringHasNewLineDelimiter(){
        assertEquals(3, StringCalculator.add("1\n2"));
    }

    @Test
    public void testStringWithTwoDelimiter(){
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testStringWithDelimiterOneDegit(){
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testStringWithDelimiterManyDegit(){
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }
}
