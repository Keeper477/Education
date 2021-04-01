package lab_4;

public class TestLab_4 {
    public static void main(String[] args) {
        Nameable tester = new Animal();
        System.out.println(tester.getName());
        tester = new Car();
        System.out.println(tester.getName());
    }
}
