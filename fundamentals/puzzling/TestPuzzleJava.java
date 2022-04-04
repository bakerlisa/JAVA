import java.util.ArrayList;

public class TestPuzzleJava {
    
	public static void main(String[] args) {
		// getTenRolls
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls(10,20);
		// System.out.println(randomRolls);
		
    	// getRandomLetter
		char newLetter = generator.getRandomLetter();
		// System.out.println(newLetter);

		// Passwordgenerator
		String newPassword = generator.generatePassword();
		// System.out.println(newPassword);

		// getNewPasswordSet
		int passLen = 10;
		String setPassword = generator.getNewPasswordSet(passLen);
		// System.out.println(setPassword);

		// SENEI BONUS: shuffleArray
		System.out.println();
		char[] myPass = {'e','w','e','l','r','o','p','x'};
		char[] shuffledPass = generator.shuffleArray(myPass);
		System.out.println(shuffledPass);

		
		// SENEI BONUS: shuffleArray #2
		char[] myPassTwo = new char[8];
		char[] shuffledPassTwo = generator.shuffleArrayTwo(myPassTwo);
		// System.out.println(shuffledPassTwo);
	}
}
