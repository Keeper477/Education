package prac_11;

public abstract class AbstractQueue<E> {
    protected java.util.Queue<E> linkedQueue;

    AbstractQueue() {
        linkedQueue = new java.util.LinkedList<>();
    }

    public E element() {
        return linkedQueue.peek();
    }

    public E dequeue() {
        return linkedQueue.poll();
    }
}
