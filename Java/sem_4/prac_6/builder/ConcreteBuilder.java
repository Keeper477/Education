package prac_6.builder;

public class ConcreteBuilder implements Builder{
    private Complex currentBuilder;
    @Override
    public void CreateComplex() {
        currentBuilder = new Complex();
    }

    @Override
    public void BuildPart1(int part1) {
        currentBuilder.re = part1;
    }

    @Override
    public void BuildPart2(int part2) {
        currentBuilder.im = part2;
    }
    Complex GetResult() {
        return currentBuilder;
    }
}
