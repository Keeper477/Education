package prac_7;

import java.util.Stack;

public class G_Stack {
    Stack<String> deck1 = new Stack<>();
    Stack<String> deck2 = new Stack<>();
    Stack<String> temp = new Stack<>();
        String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    G_Stack(){
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
                    deck1.push(a[i]);
                }
                else if (rand == 0){
                    deck2.push(a[i]);
                }
                else if (rand == 1 && deck2.size()<5){
                    deck2.push(a[i]);
                }
                else{
                    deck1.push(a[i]);
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
            String num1 = deck1.pop(), num2 = deck2.pop();
            if(num1 == "0" && num2 == "9"){
                int j = deck1.size();
                for(int i = 0; i < j; i++){
                    String tmp = deck1.pop();
                    temp.push(tmp);
                }
                deck1.push(num1);
                deck1.push(num2);
                j = temp.size();
                for(int i = 0; i < j; i++){
                    String tmp = temp.pop();
                    deck1.push(tmp);
                }
            }
            else if(num1 == "9" && num2 == "0"){
                int j = deck2.size();
                for(int i = 0; i < j; i++){
                    String tmp = deck2.pop();
                    temp.push(tmp);
                }
                deck2.push(num2);
                deck2.push(num1);
                j = temp.size();
                for(int i = 0; i < temp.size(); i++){
                    String tmp = temp.pop();
                    deck2.push(tmp);
                }
            }
            else if (num1.compareTo(num2) > 0){
                int j = deck1.size();
                for(int i = 0; i < j; i++){
                    String tmp = deck1.pop();
                    temp.push(tmp);
                }
                deck1.push(num1);
                deck1.push(num2);
                j = temp.size();
                for(int i = 0; i < j; i++){
                    String tmp = temp.pop();
                    deck1.push(tmp);
                }
            }
            else{
                int j = deck2.size();
                for(int i = 0; i < j; i++){
                    String tmp = deck2.pop();
                    temp.push(tmp);
                }
                deck2.push(num2);
                deck2.push(num1);
                j = temp.size();
                for(int i = 0; i < j; i++){
                    String tmp = temp.pop();
                    deck2.push(tmp);
                }
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
