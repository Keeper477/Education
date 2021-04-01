package prac_11;

import java.util.ArrayList;

public class ArrayQueueADT<E>{

    public boolean enqueue (ArrayList<E> arr, E e){
        return arr.add(e);
    }
    public E dequeue (ArrayList<E> arr){
        E temp = arr.get(0);
        arr.remove(0);
        return temp;
    }
    public E element(ArrayList<E> arr){
        return arr.get(0);
    }
    public int size(ArrayList<E> arr){
        return arr.size();
    }
    public boolean isEmpty(ArrayList<E> arr){
        return arr.isEmpty();
    }

    public void clear(ArrayList<E> arr){
        arr.clear();
    }
}
