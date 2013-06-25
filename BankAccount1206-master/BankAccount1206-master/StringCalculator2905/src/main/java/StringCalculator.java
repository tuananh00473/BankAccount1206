/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/29/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String s) {
        String str[] = s.split("");
        int sum = 0;
        int number = 0;
        int count = 0;
        for(int i=1; i<str.length; i++){
            try{
                number = number*10*count + Integer.parseInt(str[i]);
                count++;
            }catch(Exception e){
                sum += number;
                number = 0;
                count = 0;
            }
        }
        if(isNumber(str[str.length-1])){
            sum += number;
        }
        return sum;
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
