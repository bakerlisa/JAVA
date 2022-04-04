import java.util.Random;
import java.util.ArrayList;

class PuzzleJava {
    public ArrayList<Integer> getTenRolls(int rollAmount, int max){
        ArrayList<Integer> allRolls = new ArrayList<Integer>();
        
        int i=0;
        while(i<rollAmount){
            Random rand = new Random();
            int randInt = rand.nextInt(max); 
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
        int upperbound = 26;
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

        return password;
    }

    public String getNewPasswordSet(int passLength){
        int i = 0;
        String passwordSet = new String();

        while(i<passLength){
            passwordSet += getRandomLetter();
            i++;
        }

        return passwordSet;
    }

    public char[] shuffleArray(char[] passReset){
        System.out.println(passReset);
        char[] shuffled = passReset;
        int i = 0;
        while(i < passReset.length){
            Random rand = new Random();
            int randInt = rand.nextInt(8); 

            //shuffling begins
            char temp = shuffled[randInt];
            shuffled[randInt] = shuffled[i];
            shuffled[i] = temp;
            
            i++;
        }
        return shuffled;
    }

    public char[] shuffleArrayTwo(char[] passReset){
        char[] shuffled = new char[8];
        int i = 0;
        while(i < passReset.length){
            shuffled[i] = getRandomLetter();
            i++;
        }
        return shuffled;
    }
}
