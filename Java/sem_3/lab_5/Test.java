package lab_5;

import java.awt.*;
import javax.swing.*;

public class Test  extends JFrame  {
    JPanel shape = new JPanel();
    public Test(){
        setSize(800,500);
        shape.setLayout(new GridLayout(5, 4));
        for(int i = 0 ; i <  20; i++) {
            if ((int) (Math.random() * 2) == 1) {
                Circle cir = new Circle(50, 50);
                shape.add(cir);
            }
            else {
                Square sq = new Square(50, 50);
                shape.add(sq);
            }
            getContentPane().add(shape);
        }
    }
    public static void main(String[]args){
        Test test = new Test();
        test.setVisible(true);
    }
}
