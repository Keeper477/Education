package prac_6;


public class Sort{
    public static void main(String[]args){
        QuickSort qs = new QuickSort();
        SortingStudentsByGPA sgpa = new SortingStudentsByGPA();
        MergeSort mr = new MergeSort();
        Student[] Students1;
        Student[] Students2;
        Students1 = new Student[5];
        Students2 = new Student[5];
        Student fr = new Student("Alex", "a123", 5);
        Students1[0] = fr;
        Students2[0] = fr;
        Student sc = new Student("Bob", "v413", 4);
        Students1[1] = sc;
        Students2[1] = sc;
        Student th = new Student("Mia", "z145", 5);
        Students1[2] = th;
        Students2[2] = th;
        Student fo = new Student("Tim", "m324", 3);
        Students1[3] = fo;
        Students2[3] = fo;
        Student fi = new Student("Jhon", "u843", 2);
        Students1[4] = fi;
        Students2[4] = fi;
        for (int i = 0; i < Students1.length; i++){
            System.out.print(Students1[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
        qs.sort(Students1);
        for (int i = 0; i < Students1.length; i++){
            System.out.print(Students1[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
        sgpa.sort(Students2, 0, Students2.length-1);
        for (int i = 0; i < Students2.length; i++){
            System.out.print(Students2[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
        qs.sort(Students2);
        Student[] Students3 = mr.sort(Students1, Students2);
        for (int i = 0; i < Students3.length; i++){
            System.out.print(Students3[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }
}

