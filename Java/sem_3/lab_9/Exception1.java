package lab_9;

import java.util.Scanner;

public class Exception1 {
    public static void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Введите целое число ");
        try{
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println( 2 / i );
        }
        catch (Exception e){
            System.out.println("Ошибка");
        }
        finally {
            System.out.println( "Конец программы" );
        }


    }
    public static void main(String[] args) {
        exceptionDemo();
    }
}
