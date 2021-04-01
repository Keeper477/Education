package prac_5;

public class Rec_4 {
    public static int k = 3, s = 3, n = 0;
    public static int rec(int num){
        if (num != (int)Math.pow(10, k)){
            int sum = 0;
            for(int i = num; i != 0; i /= 10)
            {
                sum += (i % 10);
            }
            if (sum == s){
                n++;
            }
            return rec(num + 1);
        }
        return 1;
    }
    public static void main(String[]args){
        rec((int)Math.pow(10, k-1));
        System.out.println(n);
    }
}
