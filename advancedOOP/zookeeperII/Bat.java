public class Bat extends Mammal{

    // CONSTRUCTORS
    public Bat(){
        this.engeryLevel = 300;
    }
    
    public void fly(){
        setEngery(-50);
        System.out.println("Whooooooosh! Engery: " + getEngery());
    }

    public void eatHumans(){
        setEngery(25);
        System.out.println("Slurp slurp slurp! Engery: " + getEngery());
    }

    public void attackTown(){
        setEngery(-100);
        System.out.println("Snap. Crackle. Pop...and on the ceral kind! Engery: " + getEngery());
    }


}
