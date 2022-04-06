public class TestMammal {
    public static void main(String[] arg){
        // MAMMAL
        Mammal aniamlEngery = new Mammal();
        System.out.println(aniamlEngery.getEngery());

        // GORILLA
        Gorilla newGorilla = new Gorilla();
        newGorilla.throwSomething();
        newGorilla.throwSomething();
        newGorilla.throwSomething();
        newGorilla.eatBananas();
        newGorilla.eatBananas();
        newGorilla.climb();

        // BAT
        Bat newBat = new Bat();
        System.out.println(newBat.getEngery());

    }
}
