package prac_3;

public class Task_3 {
    public static void main(String[] args) throws InterruptedException {
        MyMap<Integer, Double> map = new MyMap<>();
        MySet<Integer> set = new MySet<>();
        Thread one = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                map.put(i+1, Math.pow(2, i));
            }
        });
        Thread two = new Thread(()->{
            for (int i = 3; i < 8; i++) {
                map.put(i*i, Math.pow(i, 2));
            }
        });
        Thread third = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                set.add(i);
            }
        });
        Thread four = new Thread(()->{
            for (int i = 5; i < 10; i++) {
                set.add(i*i);
            }
        });
        one.start();
        two.start();
        third.start();
        four.start();
        Thread.sleep(3000);
        System.out.println(map);
        System.out.println(set);
    }
}
