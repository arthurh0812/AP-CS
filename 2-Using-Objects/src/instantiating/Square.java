package instantiating;

public class Square {
    private double length;

    public Square(double l) {
        length = l;
    }

    public double getArea() {
        return length * length;
    }
}
