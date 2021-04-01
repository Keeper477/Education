package prac_8.snapshot;

public class S_Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("hi");
        System.out.println(originator.getState());
        caretaker.setMemento(originator.saveState());

        originator.setState("bye");
        System.out.println(originator.getState());

        originator.restoreState(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
