package prac_2;

import java.time.LocalDate;

public class Human {
    private final int age, weight;
    private final String firstName, lastName;
    private final LocalDate birthDate;
    Human(int age, String firstName, String lastName, LocalDate birthDate, int weight){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }
    public String getSecondLetterOfFirstName(){
        return firstName.substring(1);
    }

    public int getWeight() {
        return weight;
    }

    public int getMultiplication(){
        return weight*age;
    }

    @Override
    public String toString() {
        return "age: " + age +
                ", weight: " + weight +
                ", firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", birthDate: " + birthDate;
    }
}
