import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/31/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class testStringCalculator {
    @Test
    public void testShouldReturn0WithEmptyString(){
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testShouldReturnNumber(){
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testShouldReturnSum(){
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testShouldReturnSumWithLongerString(){
        assertEquals(6, StringCalculator.add("1,2,3"));
    }

    @Test
    public void testShouldReturnValueWithDownLine(){
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testShouldReturnValueWithDelimiter(){
        assertEquals(5, StringCalculator.add("//;\n2;3"));
    }

    @Test
    public void testShouldReturnSumValueWithLengthDelimiterMoreThanOneDegit(){
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testShouldReturnSumValueWithAnyDelimiter(){
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testShoultReturnMessageExceptionWithNegative(){
        try{
            assertEquals(0, StringCalculator.add("-1,2"));
            fail("Negative Exception");
        }catch (RuntimeException re){
            assertEquals("Negative Exception", re.getMessage());
        }
    }
}
