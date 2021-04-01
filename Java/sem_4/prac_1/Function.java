package prac_1;

@FunctionalInterface
public interface Function<T, R>{
    R apply(T t);
}
