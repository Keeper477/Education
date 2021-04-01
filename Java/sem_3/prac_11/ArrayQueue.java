package prac_11;

import java.util.ArrayList;

public class ArrayQueue<E> {
    private ArrayList<E> list;
    ArrayQueue(ArrayList<E> list){
        this.list = list;
    }
    public boolean enqueue (E e){
        return list.add(e);
    }
    public E dequeue (){
        E temp = list.get(0);
        list.remove(0);
        return temp;
    }
    public E element(){
        return list.get(0);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
    }

    @Override
    public String toString() {
        return "ArrayQueue: " + list;
    }
}
