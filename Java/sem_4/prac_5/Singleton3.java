package prac_5;

public class Singleton3 {
    private Singleton3() {}
    private static class Singleton {
        static final Singleton3 INSTANCE = new Singleton3();
    }
    public static Singleton3 getInstance() {
        return Singleton.INSTANCE;
    }
}
