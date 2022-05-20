package org.darlingtonschool.ap_cs.automobile;

public class Automobile {
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    private final double TANK_CAPACITY; // in gallons
    public double getTANK_CAPACITY() {
        return TANK_CAPACITY;
    }
    private double tankAmount; // in gallons

    public double getFuelAmount() {
        return tankAmount;
    }

    public void fillFuel(double numGallons) {
        if (numGallons < 0) return;
        double newAmount = tankAmount + numGallons;
        tankAmount = Math.min(newAmount, TANK_CAPACITY);
    }

    private void useFuel(double numGallons) throws AutomobileException {
        if (numGallons < 0) return;
        double newAmount = tankAmount - numGallons;
        if (newAmount < 0) throw new AutomobileException("run out of gas");
        tankAmount = newAmount;
    }

    public boolean isFuelLow() {
        return (tankAmount / TANK_CAPACITY) <= ((double)25/100);
    }

    public void fillOil(double quarts) {
        engine.increaseCurrentOil(quarts);
    }

    public boolean isOilLow() {
        return (engine.getCurrentOil() / engine.getMaximumOil()) <= ((double)25/100);
    }

    private double miles; // miles driven in total

    public double getMiles() {
        return miles;
    }

    public Automobile(Engine e, double capacity) {
        engine = e;
        TANK_CAPACITY = capacity;
        tankAmount = capacity;
        miles = 0;
    }

    // uses default precision of 0.1 mile (= 161 meter)
    public void takeTrip(double miles) throws AutomobileException {
        if (miles <= 0) return;
        drive(miles, 0.1);
    }

    public void drive(double miles, double precision) throws AutomobileException {
        double quartsOfOilPerRound = (precision / 10) * 0.05;
        double milesDriven = 0;
        for (double i = 0; i <= miles; i += precision) {
            engine.decreaseCurrentOil(quartsOfOilPerRound);
            double mpg = engine.getMilesPerGallon();
            double currMiles = Math.min(miles-milesDriven, precision);
            useFuel(currMiles/mpg);
            milesDriven += currMiles;
        }
        this.miles += milesDriven;
    }

    public void changeEngine(Engine newEngine) {
        engine = newEngine;
    }

}
