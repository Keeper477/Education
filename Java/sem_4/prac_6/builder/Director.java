package prac_6.builder;

public class Director {
    void Construct(Builder builder) {
        builder.CreateComplex();
        builder.BuildPart1(15);
        builder.BuildPart2(30);
    }
}
