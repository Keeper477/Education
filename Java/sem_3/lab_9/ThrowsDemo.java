package lab_9;

import java.util.Scanner;

public class ThrowsDemo {
    public static void getKey(){
        Scanner myScanner = new Scanner( System.in );
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter Key ");
            String key = myScanner.nextLine();
            try {
                printDetails(key);
                return;
            } catch (Exception e) {
                System.out.println("Ошибка");
            }
        }
    }
    public static void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message );
    }
    private static String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        getKey();
    }
}
