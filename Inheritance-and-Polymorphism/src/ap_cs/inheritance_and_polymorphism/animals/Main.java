package ap_cs.inheritance_and_polymorphism.animals;

public class Main {


    public static void main(String[] args) {
        Tetrapod t1 = new Tetrapod(false, "Brown");

        t1.eat();
        System.out.println("Number of legs: " + t1.getLegs());

        Dog d1 = new Dog("brown");
        d1.eat();
        System.out.println("Number of legs: " + d1.getLegs());

        Elephant e1 = new Elephant(true);
        e1.eat();
        System.out.println(e1.likesPeanuts());

        Tetrapod e2 = new Elephant(false);
        e2.eat();
//        System.out.println(e2.likesPeanuts()); does not work

        Giraffe a3 = new Giraffe(11.5);

        e2.eat();
        a3.eat();

        Tetrapod[] zoo = {e2, a3};

        Giraffe g1 = (Giraffe)zoo[1]; // possible compile-time error
        System.out.println(g1.hasLongNeck());

        for (Animal a : zoo) {
            /*
            if (a != null)
                System.out.println("Is a tetrapod.");
            if (a instanceof Giraffe && ((Giraffe) a).hasLongNeck()) {
                System.out.println("Has a long neck.");
            } else if (a instanceof Elephant)
                System.out.println("Is an elephant");
             */
            System.out.println(a);
        }
    }
}
