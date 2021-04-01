package lab_10;

import java.util.ArrayList;

class NoneType {
    private ArrayList<Object> list = new ArrayList<>();

    public void add(Object o){ list.add(o); }

    public String toString(){
        String s = "";
        for (Object o : list) {
            s += o;
            s += "\n";
        }
        return s;
    }
}

public class Runner {
    public static void main(String[] args){
        NoneType nt = new NoneType();
        nt.add(2);
        nt.add(Long.MAX_VALUE);
        nt.add("Ha-ha");
        System.out.println(nt);
    }
}
