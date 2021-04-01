package prac_6;

public class MergeSort {
    public Student[] sort(Student[] Students1, Student[] Students2) {
        Student[] Students3 = new Student[Students1.length + Students2.length];
        int i = 0, j = 0;
        for (int k = 0; k < Students3.length; k++) {
            if (i > Students1.length - 1) {
                Student temp = Students2[j];
                Students3[k] = temp;
                j++;
            }
            else if (j > Students2.length - 1) {
                Student temp = Students1[i];
                Students3[k] = temp;
                i++;
            }
            else if (Students1[i].id.compareTo(Students2[j].id) < 0) {
                Student temp = Students1[i];
                Students3[k] = temp;
                i++;
            }
            else {
                Student temp = Students2[j];
                Students3[k] = temp;
                j++;
            }
        }
        return Students3;
    }
}
