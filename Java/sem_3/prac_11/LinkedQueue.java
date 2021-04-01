package prac_11;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedQueue<E>{
    private Queue<E> linkedQueue;

    LinkedQueue() {

        linkedQueue = new LinkedList<>();
    }

    public boolean enqueue(E e) {
        return linkedQueue.offer(e);
    }

    public boolean isEmpty(E e) {
        return linkedQueue.isEmpty();
    }

    public void clear(E e) {
        linkedQueue.clear();
    }

    public E element() {
        return linkedQueue.peek();
    }

    public E dequeue() {
        return linkedQueue.poll();
    }

    public int size() {
        return linkedQueue.size();
    }

    @Override
    public String toString() {
        return "LinkedQueue: " + linkedQueue;
    }
}
