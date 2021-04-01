package prac_6.prototype;

public class P_Test {
    public static void main(String[] args) {
        Human human = new Human(12);
        Human kid = human.clone();
        System.out.println(kid.getAge());
    }
}
