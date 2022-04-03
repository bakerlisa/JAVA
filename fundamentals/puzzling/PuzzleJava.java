import java.util.Random;
import java.util.ArrayList;

class PuzzleJava {
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> allRolls = new ArrayList<Integer>();
        
        int i=0;
        while(i<10){
            Random rand = new Random();
            int upperbound = 20;
            int randInt = rand.nextInt(upperbound); 
            System.out.println(randInt);
            // allRolls.add(randInt);
            i++;
        }
        return allRolls;
    }
}
