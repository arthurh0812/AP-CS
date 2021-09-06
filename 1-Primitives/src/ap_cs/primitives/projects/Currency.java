package ap_cs.primitives.projects;

import org.jetbrains.annotations.Contract;

public enum Currency {
    USD, EUR, YEN;

    @Contract(pure = true)
    public String getName() {
        return this.name();
    }
}
