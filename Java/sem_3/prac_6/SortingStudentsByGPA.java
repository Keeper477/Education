package prac_6;

public class SortingStudentsByGPA {
        public void sort (Student[] Students, int low, int high){
            if (Students.length == 0)
                return;
            if (low >= high)
                return;
            int middle = low + (high - low) / 2;
            Student opora = Students[middle];
            int i = low, j = high;
            while (i <= j) {
                while (compare(Students[i], opora) < 0) {
                    i++;
                }

                while (compare(Students[j], opora) > 0) {
                    j--;
                }

                if (i <= j) {
                    Student temp = Students[i];
                    Students[i] = Students[j];
                    Students[j] = temp;
                    i++;
                    j--;
                }
            }
            if (low < j)
                sort(Students, low, j);

            if (high > i)
                sort(Students, i, high);
        }
        public int compare(Student temp1, Student temp2) {
            return temp1.gpa - temp2.gpa;
        }
}
