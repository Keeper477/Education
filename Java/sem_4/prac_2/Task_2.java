package prac_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Task_2 {
    public static void main(String[] args){
        ArrayList<Human> arr = new ArrayList<>();
        arr.add(new Human(19, "Sergey", "Prokofiev",
                LocalDate.of(2001, 7, 24), 60));
        arr.add(new Human(21, "Anna", "Novak",
                LocalDate.of(2003, 5, 21), 54));
        arr.add(new Human(34, "Vlad", "Nikitin",
                LocalDate.of(1987, 12, 8), 80));
        arr.add(new Human(80, "Mia", "Sosiska",
                LocalDate.of(2041, 2, 2), 70));
        arr.add(new Human(10, "Dan", "Lebedev",
                LocalDate.of(2011, 11, 11), 36));
        Stream<Human> stream1 = arr.stream();
        stream1.sorted(Comparator.comparing(Human::getSecondLetterOfFirstName))
                .forEach(System.out::println);
        System.out.println();
        Stream<Human> stream2 = arr.stream();
        stream2.filter(human -> human.getWeight()%10 == 0)
                .forEach(System.out::println);
        System.out.println();
        Stream<Human> stream3 = arr.stream();
        stream3.sorted(Comparator.comparingInt(Human::getMultiplication))
                .forEach(System.out::println);
        int ans = arr.stream()
                .mapToInt(Human::getWeight)
                .reduce(1, (a,b) -> a*b);
        System.out.println();
        System.out.println(ans);
    }
}
