package prac_6.abstract_factory;

public class PeopleFactory extends People{
    @Override
    public Woman createWoman() {
        return new Chef();
    }

    @Override
    public Man createMan() {
        return new Plumber();
    }
}
