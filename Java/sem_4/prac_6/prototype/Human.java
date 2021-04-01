package prac_6.prototype;


public class Human implements Prototype{
    int age;
    public Human(int age){
        this.age = age;
    }
    @Override
    public Human clone() {
        return new Human(age);
    }
    public int getAge() {
        return age;
    }
}
