package ap_cs.inheritance_and_polymorphism.animals;

public class Giraffe extends Tetrapod {
    private double neckLength; // in meters

    public Giraffe(double neckLength) {
        super(false, "Brown/Yellow");
        this.neckLength = neckLength;
    }

    public double getNeckLength() {
        return neckLength;
    }

    public boolean hasLongNeck() {
        return neckLength > 4;
    }

    public String toString() {
        String msg = super.toString();
        return "Giraffe: " + msg + ". Has a " + (hasLongNeck() ? "long" : "short") + " neck";
    }
}
