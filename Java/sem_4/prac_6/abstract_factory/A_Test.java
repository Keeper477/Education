package prac_6.abstract_factory;

public class A_Test {
    public static void main(String[] args) {
        PeopleFactory pf = new PeopleFactory();
        Man man = pf.createMan();
        Woman woman = pf.createWoman();
        man.FixSomething();
        woman.CookSomething();
    }
}
