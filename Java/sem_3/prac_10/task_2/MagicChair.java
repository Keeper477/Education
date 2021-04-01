package prac_10.task_2;

public class MagicChair implements Chair {
    public void doMagic(){
        System.out.println("Я исчез. ПУФ");
    };
    @Override
    public void doSomething() {
        doMagic();
    }
}
