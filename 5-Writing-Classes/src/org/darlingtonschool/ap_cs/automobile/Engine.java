package org.darlingtonschool.ap_cs.automobile;

public class Engine {
    private final String name;
    public String getName() {
        return name;
    }

    private final double MAXIMUM_MPG; // in miles/gallon
    public double getMaximumMPG() {
        return MAXIMUM_MPG;
    }

    private final double MAXIMUM_OIL; // in quarts
    public double getMaximumOil() {
        return MAXIMUM_OIL;
    }

    private double currentOil; // in quarts
    public double getCurrentOil() {
        return currentOil;
    }

    public void increaseCurrentOil(double quarts) {
        if (quarts < 0) return;
        double newOil = currentOil + quarts;
        currentOil = Math.min(newOil, MAXIMUM_OIL);
    }

    public void decreaseCurrentOil(double quarts) throws AutomobileException {
        if (quarts < 0) return;
        double newOil = currentOil - quarts;
        if (newOil <= 0) throw new AutomobileException("engine exploded");
        currentOil = newOil;
    }

    public Engine(String name, double maxMPG, double maxOil) {
        this.name = name;
        MAXIMUM_MPG = maxMPG;
        MAXIMUM_OIL = maxOil;
        currentOil = maxOil;
    }

    public double getMilesPerGallon() {
        return (currentOil / MAXIMUM_OIL) * MAXIMUM_MPG;
    }
}
