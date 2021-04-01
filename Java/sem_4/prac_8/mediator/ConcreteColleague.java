package prac_8.mediator;

public class ConcreteColleague extends Colleague{
    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println("Коллега говорит: " + message);
    }
}
