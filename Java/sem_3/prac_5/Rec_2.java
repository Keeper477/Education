package prac_5;

public class Rec_2 {
    public static int rec(int n){
        if (n != 1) {
            rec(n - 1);
        }
        System.out.println(n);
        return 1;
    }
    public static void main(String[]args){
        rec(5);
    }
}
