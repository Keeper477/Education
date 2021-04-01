package prac_8.mediator;

public class ConcreteMediator implements Mediator {
    private ConcreteColleague colleague;

    public void setColleague(ConcreteColleague colleague) {
        this.colleague = colleague;
    }

    @Override
    public void send(String message, Colleague sender) {
        colleague.notify(message);
    }
}
