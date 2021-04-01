package lab_2;

public class TestBook {
    public static void main(String[] args) {
        Book book1 = new Book("Гоголь", "Мертвые души", 1842);
        Book book2 = new Book("Толстой", "Война и мир", 1869);
        System.out.println("Автор: " + book1.get_author() + "\nНазвание: " + book1.get_name() + "\nГод: " + book1.get_year());
        System.out.println("Автор: " + book2.get_author() + "\nНазвание: " + book2.get_name() + "\nГод: " + book2.get_year());
    }
}
