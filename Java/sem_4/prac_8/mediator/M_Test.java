package prac_8.mediator;

public class M_Test {
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();
        ConcreteColleague c = new ConcreteColleague(m);
        m.setColleague(c);
        c.send("Привет");
    }
}
