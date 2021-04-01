package prac_11;

public interface Queue<E> {
    boolean enqueue  (E e);
    boolean isEmpty (E e);
    void clear  (E e);
    E element();
    E dequeue ();
    int size();
}
