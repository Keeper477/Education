package prac_1;
//Прокофьев Сергей

import java.util.Scanner; // импортируемкласс



public class Example {
    public static void main(String[] args) {
        int[] mas = new int[]{1, 3, 6, 8};
        Scanner sc = new Scanner(System.in);
        first(mas);
        for(int i = 0; i < args.length; i++){
            System.out.print(args[i]);
        }
        System.out.print('\n');
        third();
        System.out.print('\n');
        fourth();
        fifth(sc);
    }

    public static void first(int[] mas){
        int ans = 0, j = 0, k = 0;
        for(int i = 0; i < mas.length; i++){
            ans += mas[i];
        }
        System.out.print(ans);
        System.out.print('\n');
        ans = 0;
        while(j < mas.length){
            ans += mas[j];
            j++;
        }
        System.out.print(ans);
        System.out.print('\n');
        ans = 0;
        do{
            ans += mas[k];
            k++;
        }while(k < mas.length);
        System.out.print(ans);
        System.out.print('\n');
    }
    public static void third(){
        float x;
        for(float i = 1; i < 11; i++){
            x = 1/i;
            System.out.print(x);
            System.out.print(' ');
        }
    }
    public static void fourth(){

        int[] mas = new int[10];
        for(int i = 0; i < mas.length; i++){
            mas[i] = (int)(Math.random()*100);
            System.out.print(mas[i]);
            System.out.print(' ');
        }
        System.out.print('\n');
        for (int i = mas.length - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if(mas[j] > mas[j + 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < mas.length; i++){
            System.out.print(mas[i]);
            System.out.print(' ');
        }
    }
    public static void fifth(Scanner sc){
        System.out.print('\n');
        System.out.print("Введите число: ");
        if(sc.hasNextInt()) {
            int num = sc.nextInt(), ans = 1;
            for(int i = 1; i <= num; i++) {
                ans *= i;
            }
            System.out.print(ans);
        }
        else {
            System.out.println("Вы ввели нецелое число");
        }
    }
}
