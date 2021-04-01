package prac_10.task_1;

public class Complex {
    private int real;
    private int image;

    public Complex(){}

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "real: " + real +
                "\nimage: " + image;
    }
}
