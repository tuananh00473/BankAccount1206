import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/7/13
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String s) {
        return getSum(s);
    }

    public static int getSum(String s){
        int sum = 0;
        if(!s.isEmpty()){
            try{
                return toInt(s);
            }catch(Exception e){
                if(s.startsWith("//")){
                    if(s.contains("[")){
                        List<String> listDelimiter = new ArrayList<String>();
                        int startPoint = 0;
                        int endPoint = 0;
                        for(int i=0; i<s.length(); i++){
                            if(String.valueOf(s.charAt(i)).equals("[")){
                                startPoint = i;
                            }
                            if(String.valueOf(s.charAt(i)).equals("]")){
                                endPoint = i;
                                listDelimiter.add(s.substring(startPoint+1, endPoint));
                            }
                        }
                        s = s.substring(endPoint + 2);
                        for (int i=0; i<listDelimiter.size(); i++){
                            s = s.replace(listDelimiter.get(i), ",");
                        }
                    }else{
                        s = s.replace(s.substring(2, 3), ",");
                        s = s.substring(4);
                    }
                }else{
                    s = s.replace("\n", ",");
                }
                String str[] = s.split(",");
                List<Integer> listNegative = new ArrayList<Integer>();
                for (int i=0; i<str.length; i++){
                    int value = toInt(str[i]);
                    if(value < 0){
                        listNegative.add(value);
                    }else if(value<=1000){
                        sum += value;
                    }
                }
                if(listNegative.size() > 0){
                    String stringNegative = "Negative Exception With ";
                    for (int i=0; i<listNegative.size(); i++){
                        stringNegative += listNegative.get(i) + " ";
                    }
                    throw new RuntimeException(stringNegative);
                }
            }
        }
        return sum;
    }

    public static int toInt(String s){
        return Integer.parseInt(s);
    }
}
