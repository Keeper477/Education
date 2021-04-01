package prac_8;

public class BoundedWaitList<E> extends WaitList {
    private int capacity;
    BoundedWaitList(int capacity){
        super();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(Object element) {
        if (content.size()< capacity){
            content.add((E)element);
        }
        else{
            System.out.println("Места в списке закончились");
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(Object c : content){
            s +=  c + " ";
        }
        return "Размер списка = " + capacity +
                "\nCписок: " + s;
    }
}
