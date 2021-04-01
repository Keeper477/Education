package prac_7.decorator;

public class D_Test {
    public static void main(String[] args) {
        Car simpleCar = new SimpleCar();
        System.out.println("Speed of simple car - " + String.valueOf(simpleCar.getSpeed()));
        System.out.println("Simple car can accept baggage with weight " + String.valueOf(simpleCar.getBaggageWeight()));
        Car sportCar = new SportCar(simpleCar);
        System.out.println("Speed of sport car - " + String.valueOf(sportCar.getSpeed()));
        System.out.println("Sport car can accept baggage with weight " + String.valueOf(sportCar.getBaggageWeight()));
    }
}
