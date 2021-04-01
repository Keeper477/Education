package prac_10.task_2;

public class Client {
    public Chair chair;
    public void sit(){
        chair.doSomething();
    }
    public void setChair(Chair chair){
        this.chair = chair;
    }
}
