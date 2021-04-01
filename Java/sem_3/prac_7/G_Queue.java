package prac_7;

import java.util.Queue;
import java.util.LinkedList;

public class G_Queue {
    Queue<String> deck1 = new LinkedList<>();
    Queue<String> deck2 = new LinkedList<>();
    String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    G_Queue(){
        int rand = (int)(Math.random()*10);
        for (int i = 0; i < a.length; i++) {
            int j = rand;
            String temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        for(int i = 0; i < 10; i++){
            rand = (int)(Math.random()*2);
            if (rand == 0 && deck1.size()<5){
                deck1.offer(a[i]);
            }
            else if (rand == 0){
                deck2.offer(a[i]);
            }
            else if (rand == 1 && deck2.size()<5){
                deck2.offer(a[i]);
            }
            else{
                deck1.offer(a[i]);
            }
        }
    }
    public int GetEl(int num){
        if(num == 1){
            return Integer.valueOf(deck1.peek());
        }
        else {
            return Integer.valueOf(deck2.peek());
        }
    }
    public void turn(){
        String num1 = deck1.poll(), num2 = deck2.poll();
        if(num1 == "0" && num2 == "9"){
            deck1.offer(num2);
            deck1.offer(num1);
        }
        else if(num1 == "9" && num2 == "0"){
            deck2.offer(num1);
            deck2.offer(num2);
        }
        else if (num1.compareTo(num2) > 0){
            deck1.offer(num2);
            deck1.offer(num1);
        }
        else{
            deck2.offer(num1);
            deck2.offer(num2);
        }
    }
    public int len(int num){
        if(num == 1){
            return deck1.size();
        }
        else {
            return deck2.size();
        }
    }
}
