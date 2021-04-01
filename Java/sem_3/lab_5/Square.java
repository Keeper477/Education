package lab_5;

import java.awt.*;

public class Square extends Shape {

    Square(int xCenter, int yCenter){
        super(xCenter, yCenter);
    }

    @Override
    public void drawShape(Graphics g) {
        Graphics2D gp = (Graphics2D) g;
        BasicStroke pen1 = new BasicStroke(10); //толщина линии 20
        gp.setStroke(pen1);
        gp.setPaint(color);
        gp.drawRect(xCenter-10, yCenter-10, 100, 100);
    }
}
