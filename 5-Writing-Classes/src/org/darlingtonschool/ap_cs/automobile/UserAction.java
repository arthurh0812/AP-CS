package org.darlingtonschool.ap_cs.automobile;

public class UserAction implements Action {
    private final String description;
    private final Action action;

    public UserAction(String desc, Action a) {
        description = desc;
        action = a;
    }

    public String getDescription() {
        return description;
    }

    public void run(Automobile a) throws AutomobileException {
        action.run(a);
    };
}
