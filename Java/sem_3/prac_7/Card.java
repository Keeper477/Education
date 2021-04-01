package prac_7;

import java.awt.*;

public class Card extends Panel {
    int num, xCenter, yCenter;
    Card(int num){
        this.num = num;
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gp = (Graphics2D) g;
        BasicStroke pen1 = new BasicStroke(10);
        gp.setStroke(pen1);
        gp.drawRect(50, 0, 115, 150);
        if (num!= 10) {
            Font fn = new Font("Times New Roman", Font.BOLD, 25);
            gp.setFont(fn);
            gp.drawString(String.valueOf(num), 100, 75);
        }
    }
}
