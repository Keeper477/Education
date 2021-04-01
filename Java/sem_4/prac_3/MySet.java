package prac_3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet<E> extends HashSet<E> implements Set<E> {
    @Override
    synchronized public int size() {
        return super.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    synchronized public Iterator<E> iterator() {
        return super.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return super.toArray();
    }

    @Override
    synchronized public <T> T[] toArray(T[] a) {
        return super.toArray(a);
    }

    @Override
    synchronized public boolean add(E e) {
        return super.add(e);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    synchronized public boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    @Override
    synchronized public boolean addAll(Collection<? extends E> c) {
        return super.addAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    @Override
    synchronized public void clear() {
        super.clear();
    }
}
