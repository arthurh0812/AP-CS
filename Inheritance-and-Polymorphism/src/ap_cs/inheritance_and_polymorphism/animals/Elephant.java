package ap_cs.inheritance_and_polymorphism.animals;

public class Elephant extends Tetrapod {
    private boolean likesPeanuts;

    public Elephant(boolean likesPeanuts) {
        super(false, "Grey");
        this.likesPeanuts = likesPeanuts;
        if (!likesPeanuts) setCarnivore(true);
    }

    public boolean likesPeanuts() {
        return likesPeanuts;
    }
}
