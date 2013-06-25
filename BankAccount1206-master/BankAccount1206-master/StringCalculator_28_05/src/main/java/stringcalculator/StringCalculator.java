package stringcalculator;

import sun.org.mozilla.javascript.internal.ast.CatchClause;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/27/13
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String string){
        return SumValue(string);
    }

    private static int SumValue(String string) {
        int sum = 0;
        String[] str =  string.split("");
        for(String i : str){
            try{
                sum += StringToNumber(i);
                }
            catch (Exception e){
            }
        }
        return sum;
    }

    private static int StringToNumber(String string) {
        return Integer.parseInt(string);
    }
}
