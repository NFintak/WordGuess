//Nathan
import java.util.Scanner;

public class WordGuess {
	private static java.util.Random randomGenerator = new java.util.Random();
	private static String[] wordList = {"cat", "pie", "fork", "book"};
	private static int randWord = randomGenerator.nextInt(wordList.length);
	private static String keyword = wordList[randWord];

	public static void main(String[] args) {
		int numOfGuesses = 4;
		System.out.println("Let's Play Wordguess version 1.0");
		while (numOfGuesses > 0) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Current Guesses: ");
			for (int i = 0; i <= keyword.length(); i++) {
				String hiddenWord = keyword.replace(keyword.charAt(i), '_');
			}
			System.out.println();
			System.out.println("You have " + numOfGuesses + " tries left.");
			System.out.println("Enter a single character: ");
			String prompt = scan.nextLine();
			char letter = prompt.charAt(0);

			for (int i = 0; i <= (keyword.length() - 1); i++) {
				if (letter == (keyword.charAt(i))) {

				}
			}

			numOfGuesses--;
		}
	}
}