public class Mammal{
    private int engeryLevel;

    // CONSTRUCTORS
    public Mammal(){
        this.engeryLevel = 100;
    }

    public Mammal(int engeryLevel){
        this.engeryLevel = engeryLevel;
    }

    // SETTER
    public void setEngery(int level){
        engeryLevel = this.engeryLevel + level;
    }
    // GETTER
    public int getEngery(){
        return this.engeryLevel;
    }

    // METHODS
    public int displayEnergy(){
        System.out.println("Anialas has an engery leve of " + this.engeryLevel);
        return this.engeryLevel;
    }
}