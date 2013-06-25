import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/6/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String s) {
        try{
            return Integer.parseInt(s);
        }catch (Exception e){
            if(s.startsWith("//")){
                if(s.contains("[")){
                    List<String> listRegex = new ArrayList<String>();
                    int startPoint = 0;
                    int endPoint = 0;
                    for(int i=0; i<s.length(); i++){
                        if(String.valueOf(s.charAt(i)).equals("[")){
                            startPoint = i;
                        }
                        if(String.valueOf(s.charAt(i)).equals("]")){
                            endPoint = i;
                            listRegex.add(s.substring(startPoint+1, endPoint));
                        }
                    }
                    s = s.substring(endPoint+2);
                    for(int i=0; i<listRegex.size(); i++){
                        s = s.replace(listRegex.get(i), ",");
                    }
                }else{
                    s.replace(s.substring(2,3), ",");
                    s = s.substring(4);
                }
            }else{
                if (s.contains("\n")){
                    s = s.replace("\n", ",");
                }
            }
            return getSum(s);
        }
    }

    private static int getSum(String s) {
        int sum = 0;
        if(!s.isEmpty()){
            String str[] = s.split(",|;");
            List<Integer> listNegative = new ArrayList<Integer>();
            for (int i=0; i<str.length; i++){
                int value = Integer.parseInt(str[i]);
                if(value<0){
                    listNegative.add(value);
                }else if (value<=1000){
                    sum += value;
                }
            }
            if(listNegative.size() > 0 ){
                String messageNegative = "Negative Exception With ";
                for (int i=0; i<listNegative.size(); i++){
                    messageNegative += listNegative.get(i) + " ";
                }
                throw new RuntimeException(messageNegative);
            }
        }
        return sum;
    }
}
