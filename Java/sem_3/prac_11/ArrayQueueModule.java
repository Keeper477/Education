package prac_11;

import java.util.ArrayList;

public class ArrayQueueModule<E> {
    private ArrayList<E> list = new ArrayList<E>();

    public void add(E e){
        list.add(e);
    }

    public ArrayList<E> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ArrayQueueModule: " + list;
    }
}
