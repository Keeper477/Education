package lab_5;
import java.awt.*;

public abstract class Shape extends Panel {
    public Color color;
    public int xCenter;
    public int yCenter;
    Shape(int xCenter, int yCenter){
        this.color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public void drawShape(Graphics g){}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gp = (Graphics2D) g;
        drawShape(g);
    }

}
