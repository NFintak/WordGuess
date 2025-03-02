//Nathan
import java.util.Scanner;

public class WordGuess {

	public static void main(String[] args) {
		WordGuess game = new WordGuess();
		game.runGame();
	}

	public void runGame() {
		java.util.Random randomGenerator = new java.util.Random();
		String[] wordList = {"cat", "pie", "fork", "book"};
		int randWord = randomGenerator.nextInt(wordList.length);
		String keyword = wordList[randWord];
		int numOfGuesses = 4;
		boolean wordGuessed = false;
		String hiddenWord = new String(new char[keyword.length()]).replace("\0", "*");


		while (wordGuessed = false) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Current Guesses: ");

			System.out.println(hiddenWord);
			System.out.println();
			System.out.println("You have " + numOfGuesses + " tries left.");
			System.out.println("Enter a single character: ");
			String prompt = scan.nextLine();
			char letter = prompt.charAt(0);

/*
			for (int i = 0; i <= (keyword.length() - 1); i++) {
				if (letter == keyword.charAt(i)) {
					hiddenWord = hiddenWord.replace(hiddenWord.charAt(i), letter);
					System.out.println(hiddenWord);
				}
			}
			if (hiddenWord.equals(keyword)) {
				System.out.println();
			}
*/
			numOfGuesses--;
		}
	}
}
