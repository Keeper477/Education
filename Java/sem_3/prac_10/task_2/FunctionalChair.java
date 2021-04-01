package prac_10.task_2;

public class FunctionalChair implements Chair {
    public int sum(int a, int b){
        return a + b;
    }

    @Override
    public void doSomething() {
        System.out.println("Я посчитал 2 + 2 = " + sum(2, 2));
    }
}
