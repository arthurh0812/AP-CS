package ap_cs.inheritance_and_polymorphism.animals;

public class Dog extends Tetrapod {

    public Dog(String color) {
        super(true, color);
    }

    public void bark() {
        System.out.println("Barking...");
    }
}
