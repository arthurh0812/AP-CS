package org.darlingtonschool.ap_cs.automobile;

public class Bus {
    private final int STOPS;
    private int currStop;
    public Bus(int numStops) {
        STOPS = numStops;        currStop = 1;
    }
    public int getCurrentStop() {
        return currStop;
    }

    private boolean updateUpwards() {
        if (currStop == 1)
            return true;
        if (currStop == STOPS)
            return false;
        return true
    }
    public void move() {
        boolean upwards = updateUpwards();
        if (upwards)
            currStop++;
        else
            currStop--;
    }
}