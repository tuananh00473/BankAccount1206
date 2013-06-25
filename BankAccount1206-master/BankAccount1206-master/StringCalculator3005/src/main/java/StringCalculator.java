/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/30/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String s) {
        if(s.equals("")){
            return 0;
        }else if(isNumber(s)){
            return Integer.parseInt(s);
        }else if(!isNumber(s)){
            if(isContainDelimiter(s, "\n")){
                if(isContainDelimiter(s, "//")){
                    if(isContainDelimiter(s, "[")){
                        //==================== Dua tat ca regex vao mot arrayList de test not truong hop cuoi cung (nhieu Delimiter) ====================//
                        String str[] = s.split("");
                        int startPoint = 0;
                        int endPoint = 0;
                        for(int i=1; i<str.length; i++){
                            if(str[i].equals("[")){
                                startPoint = i;
                            }
                            if(str[i].equals("]")){
                                endPoint = i-1;
                                String regex = s.substring(startPoint, endPoint);
                                s = s.substring(endPoint+2);
                                s = s.replace(regex, ",");
                                String strx[] = s.split(",");
                                int sumX = 0;
                                for(int j=0; j<strx.length; j++){
                                    sumX += Integer.parseInt(strx[j]);
                                }
                                return sumX;
                            }
                        }
                        //====================================================//
                    }else{
                        String regex = s.substring(2, 3);
                        s = s.substring(4);
                        String str[] = s.split(regex);
                        int sum = 0;
                        for(int i=0; i<str.length; i++){
                            sum += Integer.parseInt(str[i]);
                        }
                        return sum;
                    }

                }else{
                    s = s.replace("\n", ",");
                    if(isNumber(s)){
                        return Integer.parseInt(s);
                    }else{
                        String str[] = s.split(",|;");
                        int sum = 0;
                        for (int i=0; i<str.length; i++){
                            sum += Integer.parseInt(str[i]);
                        }
                        return sum;
                    }
                }
            } else{
                String str[] = s.split(",|;");
                int sum = 0;
                for (int i=0; i<str.length; i++){
                    sum += Integer.parseInt(str[i]);
                }
                return sum;
            }

        }
        return -1;
    }

    public static boolean isContainDelimiter(String string, String delimiter){
        if(string.contains(delimiter)) return true;
        return false;
    }

    public static boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
