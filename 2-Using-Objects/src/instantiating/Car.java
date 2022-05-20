package instantiating;

public class Car {
    private String maker;
    private int year;

    public Car(int y, String m) {
        maker = m;
        year = y;
    }

    public Car() {
        maker = "";
        year = 0;
    }

    public String getInfo() {
        if (maker != "") {
            return maker + "-" + year;
        }
        return "";
    }
}
