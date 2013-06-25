import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 5/25/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class test {

    public void testx(String str){
        if(str == null | str.length()==0){
            System.out.println("emp");
        }                             else{
            System.out.println("not emp");
        }

    }
    public static void main(String[] args) {
        test t = new test();
        t.testx(null);
    }


}

