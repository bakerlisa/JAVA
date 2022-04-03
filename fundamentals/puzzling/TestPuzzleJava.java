import java.util.ArrayList;

public class TestPuzzleJava {
    
	public static void main(String[] args) {
		// RANDOM ARRAY OF ROLLS
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
    	// RANDOM CHARACTER
		char newLetter = generator.getRandomLetter();
		System.out.println(newLetter);

		// Passwordgenerator
		String newPassword = generator.generatePassword();
		System.out.println(newPassword);

	}
}
