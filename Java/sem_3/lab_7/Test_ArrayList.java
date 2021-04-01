package lab_7;

import java.util.ArrayList;

public class Test_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Илья");
        names.add("Сережа");
        names.add("Даниил");
        names.add("Андрей");
        names.add(3, "Лена");
        System.out.println(names.get(3));
        names.set(1, "Ирина");
        System.out.printf("В списке %d элементов \n", names.size());
        for(String state : names){
            System.out.println(state);
        }
        if(names.contains("Даниил")){
            System.out.println("В списке есть Даниил");
        }
        names.remove("Даниил");
        names.remove(0);
        Object[] countries = names.toArray();
        for(Object country : countries){
            System.out.println(country);
        }
    }
}
