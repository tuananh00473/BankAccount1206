package stringcalculator;

import sun.org.mozilla.javascript.internal.ast.CatchClause;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/27/13
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String string){
        if (string.equals("")){
            return 0;
        } else if(isNumber(string)){
            return StringToNumber(string);
        } else if(isContainNonNumber(string)){
            String[] substr = string.split(getRegex(string));
        }
        return -1;
    }

    private static String getRegex(String string) {
        String[] str =  string.split("");
        for(int i=0; i<str.length; i++){
            try{
                Integer.parseInt(str[i]);
            } catch(Exception e){
                return str[i];
            }
        }
        return null;
    }

    private static boolean isContainNonNumber(String string) {
        String[] str =  string.split("");
        for(int i=0; i<str.length; i++){
            try{
                Integer.parseInt(str[i]);
            } catch(Exception e){
                return true;
            }
        }
        return false;
    }

    private static int StringToNumber(String string) {
        return Integer.parseInt(string);
    }

    public static boolean isNumber(String string){
        try{
            Integer.parseInt(string);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
