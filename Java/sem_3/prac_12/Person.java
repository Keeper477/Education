package prac_12;

public class Person {
    private String surn, name, patr;
    Person(String surn, String name, String patr){
        this.surn = surn;
        this.name = name;
        this.patr = patr;
    }
    Person(String surn){
        this.surn = surn;
    }
    public String getFCS(){
        if(name == null)
            return surn;
        else
            return String.format("%s %.1s.%.1s.", surn, name, patr);
    }
}
