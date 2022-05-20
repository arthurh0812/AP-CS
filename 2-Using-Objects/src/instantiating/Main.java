package instantiating;

public class Main {

    public static void main(String args[]) {
        persons();

        dogs();

        squares();

        cars();
    }

    private static void persons() {
        Person amy = new Person();
        amy.setName("Amy");
        System.out.println(amy.getName());

        Person marc = new Person("Marc");
        System.out.println(marc.getName());
    }

    private static void dogs() {
        Dog snoopy = new Dog("beagle");
        String name = snoopy.getName(); // "beagle"
        System.out.println(name);
    }

    private static void squares() {
        Square square1 = new Square(5);
        double area = square1.getArea(); // 25.0
        System.out.println(area);
    }

    private static void cars() {
        Car car1 = new Car(2017, "Honda");
        String info = car1.getInfo(); // Honda-2017
        System.out.println(info);
    }
}
