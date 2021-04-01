package prac_5;

public class Rec_3 {
    public static int rec(int a, int b){
        if (a != b) {
            if (a > b){
                rec(a, b+1);
            }
            else {
                rec(a, b -1);
            }
        }
        System.out.println(b);
        return 1;
    }
    public static void main(String[]args){
        rec(8, 6);
    }
}
