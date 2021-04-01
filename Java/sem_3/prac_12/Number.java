package prac_12;

public class Number {
    String number;
    Number(String number){
        this.number = number;
    }

    @Override
    public String toString() {
        String s = "+";
        if (number.indexOf("+") == 0){
            s += number.substring(1, number.length() - 7) + "-"
                    + number.substring(number.length() - 7, number.length() - 4) + "-"
                    + number.substring(number.length() - 4);
        }
        else {
            s += "7"+ number.substring(1, 4) + "-"
                    + number.substring(4, 7) + "-"
                    + number.substring(7);
        }
        return s;
    }
}
