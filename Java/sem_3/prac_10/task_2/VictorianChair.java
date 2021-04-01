package prac_10.task_2;

public class VictorianChair implements Chair {
    private int age;

    VictorianChair(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void doSomething() {
        System.out.println("Какой я старый! Мне: " + getAge() + " лет");
    }
}
