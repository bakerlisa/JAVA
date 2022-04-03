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
            allRolls.add(randInt);
            i++;
        }
        return allRolls;
    }

    public char getRandomLetter(){
        char randChars;
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    
        // gets random number
        Random rand = new Random();
        int upperbound = 25;
        int randInt = rand.nextInt(upperbound); 
        
        //sets the radnom character to be returned
        randChars=alphabet[randInt];

        return randChars;
    }

    public String generatePassword(){
        String password = new String();
        int passLength = 8;
        int i=0;
        while(i<passLength){
            password += getRandomLetter();
            i++;
        }
        System.out.println(password);

        return password;
    }
}
