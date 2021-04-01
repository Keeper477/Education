package prac_3.Movable;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    MovablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public String toString() {
        return "x = " + x +", y = " + y +", xSpeed = " + xSpeed +", ySpeed = " + ySpeed;
    }
    public void moveUp(){
        y = y + ySpeed;
    }
    public void moveDown(){
        y = y - ySpeed;
    }
    public void moveLeft(){
        x = x + xSpeed;
    }
    public void moveRight(){
        x = x + xSpeed;
    }
}
