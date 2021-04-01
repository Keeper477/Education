package prac_11;

import java.util.Scanner;

public class Tester {
    public static void main(String[] ar) {
        ArrayQueueModule<Integer> aqm = new ArrayQueueModule<>();
        LinkedQueue<Integer> lq = new LinkedQueue<>();
        Scanner scan = new Scanner(System.in);
        int temp;
        System.out.println("Введите 4 значения: ");
        for (int i = 0; i < 4; i++) {
            temp = scan.nextInt();
            aqm.add(temp);
            lq.enqueue(temp);
        }
        ArrayQueue<Integer> aq = new ArrayQueue<>(aqm.getList());
        ArrayQueueADT<Integer> aqa = new ArrayQueueADT<>();
        System.out.println(lq);
        System.out.println(aq.element());
        System.out.println(aqa.size(aqm.getList()));
        System.out.println(aqm);
        lq.dequeue();
        aq.enqueue (13);
        System.out.println(lq);
        System.out.println(aq);
        aqa.enqueue(aqm.getList(), 15);
        System.out.println(aqm);
    }
}
