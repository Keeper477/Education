package lab_3;

public class TestDog {
    public static void main(String[] args) {
        Akita_inu dog1 = new Akita_inu("Хатико", 2015, 5);
        Golden_retriever dog2 = new Golden_retriever("Вилли", 2019, 4, 5);
        System.out.println("Имя: " + dog1.get_name() + "\nГод рождения: " + dog1.get_year());
        System.out.println("Имя: " + dog2.get_name() + "\nГод рождения: " + dog1.get_year());
        System.out.println(dog1.get_name() + ": " + dog1.waiting());
        System.out.println(dog2.get_name() + ": " + dog2.friend());
    }
}
