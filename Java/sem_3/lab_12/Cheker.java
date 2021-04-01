package lab_12;

import java.util.Scanner;
import java.util.regex.*;

public class Cheker {
    public static void main(String[] ar) {
        Pattern p1 = Pattern.compile("abcdefghijklmnopqrstuv18340");
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.next();
        Matcher m1 = p1.matcher( input );
        boolean b = m1.matches();
        System.out.println(b);
    }
}
