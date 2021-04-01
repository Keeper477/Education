package prac_8;

import prac_6.Student;

public class Test {
    public static void main(String[]args){
        UnfairWaitList unw = new UnfairWaitList();
        BoundedWaitList bow = new BoundedWaitList(3);
        Student fr = new Student("Alex", "a123", 5);
        unw.add(fr);
        bow.add(fr);
        Student sc = new Student("Bob", "v413", 4);
        unw.add(sc);
        bow.add(sc);
        Student th = new Student("Mia", "z145", 5);
        unw.add(th);
        bow.add(th);
        Student fo = new Student("Tim", "m324", 3);
        unw.add(fo);
        bow.add(fo);
        System.out.println();
        System.out.println(unw);
        System.out.println(bow);
        bow.remove();
        Student fi = new Student("Jhon", "u843", 2);
        unw.add(fi);
        bow.add(fi);
        System.out.println();
        System.out.println(unw);
        System.out.println(bow);
        unw.moveToBack(fr);
        unw.remove(sc);
        System.out.println();
        System.out.println(unw);
        System.out.println(bow);
    }
}
