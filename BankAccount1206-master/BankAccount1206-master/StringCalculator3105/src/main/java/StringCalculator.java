import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/31/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String s) {
        if(s.equals("")) return 0;
        if(s.contains("-")){
            throw new RuntimeException("Negative Exception");
        }
        try{
            return Integer.parseInt(s);
        }catch(Exception e){
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
                           listRegex.add(s.substring(startPoint + 1, endPoint));
                       }
                   }
                   s = s.substring(endPoint+2);
                   for(int i=0; i<listRegex.size(); i++){
                       s = s.replace(listRegex.get(i), ",");
                   }
                }else{
                   s = s.replace(s.substring(2,3), ",");
                   s = s.substring(4);
                }
            }else if(s.contains("\n")){
                s = s.replace("\n", ",");
            }
            String str[] = s.split(",");
            int sum = 0;
            for(int i=0; i<str.length;i++){
                sum += Integer.parseInt(str[i]);
            }
            return sum;
        }
    }
}
