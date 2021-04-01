package lab_3;

public abstract  class Dog {
    private String name;
    private int year;
    public  Dog(String t_name, int t_year){
        name = t_name;
        year = t_year;
    }
    public String barking(){
        return "Гав";
    }
    public String get_name(){
        return name;
    }
    public int get_year(){
        return year;
    }
}




