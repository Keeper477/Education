package prac_6;

public class Student {
    public String id, name;
    public int gpa;
    public Student(String name, String id, int gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return  name + " id: " + id + ", оценка: " + gpa +  ";";
    }
}
