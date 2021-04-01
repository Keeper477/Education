package prac_1;

public class Task_1 {
    public static void main(String[] args) {
        int[] arr = {15, 24};
        Function<int[], String> ans = x -> euclid(arr);
        System.out.println(ans.apply(arr));
    }
    public static String euclid(int[] arr){
        while (arr[1] !=0) {
            int tmp = arr[0] % arr[1];
            arr[0]  = arr[1];
            arr[1] = tmp;
        }
        return String.valueOf(arr[0]);
    }
}
