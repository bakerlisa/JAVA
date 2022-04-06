public class Mammal{
    private int engeryLevel;

    // CONSTRUCTOR
    public Mammal(){

    }

    // SETTER
    public void setEngery(int level){
        this.engeryLevel = level;
    }
    // GETTER
    public int getEngery(){
        return this.engery;
    }

    // METHODS
    public int displayEnergy(){
        System.out.println("Anialas has an engery leve of " + this.engeryLevel);
        return this.engeryLevel;
    }
}