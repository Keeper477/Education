package lab_2;

class Book {
    private String author;
    private String name;
    private int year;
    public Book(String t_author,String t_name, int t_year){
        author = t_author;
        name = t_name;
        year = t_year;

    }
    public String get_author(){
        return author;
    }
    public String get_name(){
        return name;
    }
    public int get_year(){
        return year;
    }
}

