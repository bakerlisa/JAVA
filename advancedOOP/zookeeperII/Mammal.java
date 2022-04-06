public class Mammal{
    public int engeryLevel;

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
        return this.engeryLevel;
    }
}