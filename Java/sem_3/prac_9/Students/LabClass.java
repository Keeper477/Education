package prac_9.Students;

import prac_6.QuickSort;
import prac_6.SortingStudentsByGPA;
import prac_6.Student;

public class LabClass {
    SortingStudentsByGPA srt = new SortingStudentsByGPA();
    QuickSort qs = new QuickSort();
    Student fr;
    Student[] Students = new Student[5];;
    LabClass(){
        srt = new SortingStudentsByGPA();
        fr = new Student("Alex", "a123", 5);
        Students[0] = fr;
        Student sc = new Student("Bob", "v413", 4);
        Students[1] = sc;
        Student th = new Student("Mia", "z145", 5);
        Students[2] = th;
        Student fo = new Student("Tim", "m324", 3);
        Students[3] = fo;
        Student fi = new Student("Jhon", "u843", 2);
        Students[4] = fi;
    }
    public Student find(String name){
        for (int i = 0; i < Students.length; i++){
            if (Students[i].name.equals(name)){
                return Students[i];
            }
        }
        return null;
    }
}
