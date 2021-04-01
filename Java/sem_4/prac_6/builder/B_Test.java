package prac_6.builder;

public class B_Test {
    public static void main(String[] args) {
        ConcreteBuilder B = new ConcreteBuilder();
        Director D = new Director();
        D.Construct(B);
        Complex C = B.GetResult();
        System.out.println("C.re = " + C.re);
        System.out.println("C.im = " + C.im);
    }
}
