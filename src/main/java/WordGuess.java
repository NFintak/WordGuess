//Nathan
import java.util.Scanner;

public class WordGuess {
	public static void main(String[] args) {
		java.util.Random randomGenerator = new java.util.Random();
		int numOfGuesses = 4;
		String[] wordList = {"cat", "pie", "fork", "book"};
		int randWord = randomGenerator.nextInt(wordList.length);
		String keyword = wordList[randWord];

	}
}