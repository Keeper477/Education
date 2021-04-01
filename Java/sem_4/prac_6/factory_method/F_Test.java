package prac_6.factory_method;

public class F_Test {
    public static void main(String[] args) {
        HumanFactory hf = new HumanFactory();
        Human st = hf.getHuman("Student");
        st.sleep();
        Human sc = hf.getHuman("Schoolboy");
        sc.sleep();
    }
}
