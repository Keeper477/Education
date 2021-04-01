package prac_6.factory_method;

public class HumanFactory {
    public Human getHuman(String human){
        if (human.equals("Student")){
            return new Student();
        }
        else if(human.equals("Schoolboy")){
            return new Schoolboy();
        }
        return null;
    }
}
