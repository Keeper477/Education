package prac_6;

public class QuickSort {
    public void sort (Student[] Students)  {
        int i,j;
        Student key;
        for (j = 1; j < Students.length; j++) { //the condition has changed
            key = Students[j];
            i = j - 1;
            while (i >= 0) {
                if (key.id.compareTo(Students[i].id) > 0) {//here too
                    break;
                }
                Students[i + 1] = Students[i];
                i--;
            }
            Students[i + 1] = key;
        }
    }
}
