package org.darlingtonschool.ap_cs.automobile;

import java.io.PrintStream;
import java.util.Scanner;

public class Tester {
    private static final Engine[] ENGINES = new Engine[]{
            new Engine("Diesel Engine", 33, 7),
            new Engine("Rotary Engine", 20, 5),
            new Engine("Jet Engine", 65, 12),
    };

    private static final Scanner input = new Scanner(System.in);
    private static final PrintStream output = System.out;

    public static void main(String[] args) {
        int turns = retrieveInt("Please enter the number of turns (1-10):", 1, 10);
        Engine e = retrieveEngine();
        double fuelCapacity = retrieveDouble("Please enter the fuel capacity (in gallons):", 0, 500);
        Automobile a = new Automobile(e, fuelCapacity);

        int currTurn = 1;
        while (currTurn <= turns) {
            currTurn += executeAction(a, turns);
        }
    }

    public static int executeAction(Automobile a, int turns) {
        help();
        int action = retrieveInt(1, ACTIONS.length);
        for (int i = 0; i < ACTIONS.length; i++) {
            if (action == i+1) {
                try {
                    ACTIONS[i].run(a);
                } catch (AutomobileException ex) {
                    output.println("FAIL: " + ex.getMessage());
                    return turns;
                }
            }
        }
        display(a);
        warn(a);
        return 1;
    }

    public static int retrieveInt() {
        String line = input.nextLine();
        while (true) {
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                output.println("Please enter a valid integer value.");
                line = input.nextLine();
            }
        }
    }

    public static int retrieveInt(String msg) {
        output.println(msg);
        return retrieveInt();
    }

    public static int retrieveInt(int lowerBounds, int upperBounds) {
        int n = retrieveInt();
        while (n < lowerBounds) {
            output.printf("The integer value cannot be lower than %d.\n", lowerBounds);
            n = retrieveInt();
        }
        while (upperBounds < n) {
            output.printf("The integer value cannot be greater than %d.\n", upperBounds);
            n = retrieveInt();
        }
        return n;
    }

    public static int retrieveInt(String msg, int lowerBounds, int upperBounds) {
        output.println(msg);
        return retrieveInt(lowerBounds, upperBounds);
    }

    public static double retrieveDouble() {
        String line = input.nextLine();
        while (true) {
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                output.println("Please enter a valid floating-point value.");
                line = input.nextLine();
            }
        }
    }

    public static double retrieveDouble(String msg) {
        output.println(msg);
        return retrieveDouble();
    }

    public static double retrieveDouble(double lowerBounds, double upperBounds) {
        double f = retrieveDouble();
        while (f < lowerBounds) {
            output.printf("The floating-point value cannot be smaller than %.2f.\n", lowerBounds);
            f = retrieveDouble();
        }
        while (upperBounds < f) {
            output.printf("The floating-point value cannot be greater than %.2f.\n", upperBounds);
            f = retrieveDouble();
        }
        return f;
    }

    public static double retrieveDouble(String msg, double lowerBounds, double upperBounds) {
        output.println(msg);
        return retrieveDouble(lowerBounds, upperBounds);
    }

    public static Engine retrieveEngine() {
        for (int i = 0; i < ENGINES.length; i++) {
            Engine curr = ENGINES[i];
            output.printf("[%d] %s: %.3f maximum miles per gallon; %.3f maximum quarts of oil\n", i+1, curr.getName(), curr.getMaximumMPG(), curr.getMaximumOil());
        }
        int numEngine = retrieveInt("Please enter the engine which to choose:", 1, ENGINES.length);
        return ENGINES[numEngine-1];
    }

    public static void display(Automobile a) {
        output.printf("Miles driven: %.3f\n", a.getMiles());
        output.printf("Miles per gallon: %.3f\n", a.getEngine().getMilesPerGallon());
        output.printf("Tank size: %.3f gallons\n", a.getTANK_CAPACITY());
        output.printf("Engine size: %.3f quarts of oil\n", a.getEngine().getMaximumOil());
    }

    private static final Action fillTank = (Automobile a) -> {
        double gallons = retrieveDouble("Fill up the tank by this many gallons:", 0, 500);
        a.fillFuel(gallons);
    };

    private static final Action fillOil = (Automobile a) -> {
        double quarts = retrieveDouble("Fill up the engine by this many quarts of oil:", 0, 30);
        a.fillOil(quarts);
    };

    private static final Action readGauges = (Automobile a) -> {
        System.out.printf("Amount of fuel: %.3f\n", a.getFuelAmount());
        System.out.printf("Quarts of oil: %.3f\n", a.getEngine().getCurrentOil());
    };

    private static final Action changeEngine = (Automobile a) -> {
        Engine e = retrieveEngine();
        a.changeEngine(e);
    };

    private static final Action takeTrip = (Automobile a) -> {
        double miles = retrieveDouble("Please enter the number of miles to drive:", 0, 50000);
        a.takeTrip(miles);
    };

    private static final Action takeBetterTrip = (Automobile a) -> {
        double miles = retrieveDouble("Please enter the number of miles to drive:", 0, 50000);
        double precision = retrieveDouble("Please enter the precision (in miles):", 0.001, 10);
        a.drive(miles, precision);
    };

    private static final UserAction[] ACTIONS = {
            new UserAction("fill up the tank", fillTank),
            new UserAction("fill up the oil", fillOil),
            new UserAction("read the gauges", readGauges),
            new UserAction("change the engine", changeEngine),
            new UserAction("take a trip", takeTrip),
            new UserAction("take a trip with precision", takeBetterTrip)
    };

    public static void help() {
        output.println("What action do you want to perform?");
        for (int i = 0; i < ACTIONS.length; i++) {
            output.printf("[%d] %s\n", i+1, ACTIONS[i].getDescription());
        }
    }

    public static void warn(Automobile a) {
        if (a.isFuelLow())
            output.println("Warning!! Fuel Below 25%! Tank soon.");
        if (a.isOilLow())
            output.println("Warning!! Oil Below 25%! Fill up Oil soon.");
    }
}
