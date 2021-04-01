package prac_3.Shape;

public class Rectangle extends Shape {
    protected double width;
    protected double length;
    Rectangle(){}
    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return length*width;
    }
    public double getPerimeter() {
        return length*2 + width*2;
    }
    public String toString() {
        return "Shape: rectangle, width: " + width + ", length: " + length +", color: " + color;
    }
}
