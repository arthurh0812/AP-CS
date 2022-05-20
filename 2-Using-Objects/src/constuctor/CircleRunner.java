package constuctor;

public class CircleRunner {
    public static void main(String[] args) {
        //Test-1
        Circle c = new Circle(6);
        System.out.println(c.getRadius());

        //Test-2
        Circle c2 = new Circle(100);
        System.out.println(c2.getRadius());

        //Test-3
        Circle c3 = new Circle(10);
        System.out.println(c3.getRadius());
    }
}
