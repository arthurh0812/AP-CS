package ap_cs.inheritance_and_polymorphism.animals;

public class Animal {
    private int legs;
    private String color;
    private boolean carnivore;

    public Animal(int legs, boolean carnivore, String color) {
        this.legs = legs;
        this.carnivore = carnivore;
        this.color = color;
    }

    public void eat() {
        if (carnivore) {
            System.out.println("Eating meat...");
        } else {
            System.out.println("Eating something vegetarian...");
        }
    }

    public int getLegs() {
        return legs;
    }

    public void setCarnivore(boolean t) {
        carnivore = t;
    }

    public String toString() {
        if (carnivore) {
            return "Carnivore (" + color + ") with " + legs + " legs";
        } else {
            return "Vegetarian (" + color + ") with " + legs + " legs";
        }
    }
}
