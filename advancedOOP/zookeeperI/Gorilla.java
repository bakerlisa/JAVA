public class Gorilla extends Mammal {

    public void throwSomething(){
        setEngery(-5);
        System.out.println("I'm out of poop. does anyone have anymore poop to throw? Engery at: " + getEngery());
    }

    public void eatBananas(){
        setEngery(10);
        System.out.println("BANANAS!!!! Engery at: " + getEngery());
    }

    public void climb(){
        setEngery(-10);
        System.out.println("Gorilla's do not climb. We are higher species. Engery at: " + getEngery());
    }
}
