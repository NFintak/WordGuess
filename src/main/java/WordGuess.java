//Nathan
import java.util.Scanner;

public class WordGuess {

	public static void main(String[] args) {
		java.util.Random randomGenerator = new java.util.Random();
		String[] wordList = {"cat", "pie", "fork", "book"};
		int randWord = randomGenerator.nextInt(wordList.length);
		String keyword = wordList[randWord];
		int numOfGuesses = 4;

		System.out.println("Let's Play Wordguess version 1.0");

		while (numOfGuesses > 0) {
			Scanner scan = new Scanner(System.in);
			String hiddenWord = "";
			for (int i = 0; i <= (keyword.length() - 1); i++) {
				hiddenWord = keyword.replace(keyword.charAt(i), '*');
			}
			System.out.println("Current Guesses: ");

			System.out.println(hiddenWord);
			System.out.println();
			System.out.println("You have " + numOfGuesses + " tries left.");
			System.out.println("Enter a single character: ");
			String prompt = scan.nextLine();
			char letter = prompt.charAt(0);

			/*
			for (int i = 0; i <= (keyword.length() - 1); i++) {
				if (letter != (keyword.charAt(i))) {
					System.out.println("");
				}
			}
			*/
			numOfGuesses--;
		}
	}
}