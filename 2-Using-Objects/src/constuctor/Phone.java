package constuctor;

public class Phone {
    private String modelName;
    private double screenSize;

    public Phone(String mName, double sSize) {
        modelName = mName;
        screenSize = sSize;
    }

    public String getVars() {
        return modelName + "-" + screenSize;
    }
}
