package prac_8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList<E> implements IWaitList{
    protected ConcurrentLinkedQueue<E> content;

    WaitList(){
        content = new ConcurrentLinkedQueue<E>();
    }

    WaitList(Collection<E> c){
        content = (ConcurrentLinkedQueue<E>) c;
    }

    @Override
    public String toString() {
        String s = "";
        for(Object c : content){
            s +=  c + " ";
        }
        return s;
    }

    @Override
    public void add(Object element) {
        content.add((E) element);
    }

    @Override
    public Object remove() {
        return content.poll();
    }

    @Override
    public boolean contains(Object element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection c) {
        return content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }
}
