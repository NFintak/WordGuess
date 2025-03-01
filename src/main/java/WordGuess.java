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
			System.out.println("Current Guesses: ");
			for (int i = 0; i <= keyword.length(); i++) {
				System.out.print("_");
			}

			numOfGuesses--;
		}
	}
}