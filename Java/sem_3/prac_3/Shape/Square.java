package prac_3.Shape;

public class Square extends Rectangle {
    Square(){}
    Square(double side){
        super(side,side);
    }
    Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }
    public double getSide(){
        return length;
    }
    public void setSide(double side){
        width = side;
        length = side;
    }
    public void setWidth(double side) {
        setSide(side);
    }
    public void setLength(double side) {
        setSide(side);
    }
    public String toString() {
        return "Shape: square, side: " + width +", color: " + color;
    }
}
