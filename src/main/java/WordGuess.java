//Nathan
import java.util.Scanner;

public class WordGuess {
	java.util.Random randomGenerator = new java.util.Random();
	Scanner scan = new Scanner(System.in);
	String[] wordList = {"cat", "pie", "fork", "tree"};
	int randomNum = randomGenerator.nextInt(wordList.length);
	String keyword;
	boolean playGame = true;
	char[] userGuesses = new char[keyword.length()];
	boolean wordGuessed = false;
	int guessesLeft = keyword.length();
	char letter;
	char[] keyArray;
	String displayGuesses;

	public void announceGame() { //welcome message
		System.out.println("Let's Play Wordguess version 1.0");
	}


	public void printArray() { //formats user guesses with spaces
		for (int i = 0; i < keyword.length(); i++) {

		}

	}

	public void initializeGameState() { //sets char array for secret word and guesses
		 keyword = wordList[randomNum];
		 keyArray = keyword.toCharArray();
	}

	public char getNextGuess() { //returns player input for guess
		System.out.println("Enter a single character: ");
		String prompt = scan.next();
		letter = prompt.charAt(0);
		guessesLeft--;
		return letter;
	}

	public void printCurrentState() { //use printArray to show correct player guesses
		if (!wordGuessed && guessesLeft > 0) {
			this.printArray();
		}
	}

	public process() { //cycles thru word array and compares against input guess, replaces _ if correct

		for (int i = 0; i <= (keyword.length() - 1); i++) {
			if (letter == keyArray[i]) {
				letter = new char[userGuesses.(i)];
			}
		}
	}

	public boolean isWordGuessed() { //return boolean, if true display win message
		if (keyword.equals(userGuesses.toString())) {
			this.playerWon();
			return wordGuessed = true;
		} else {
			this.playerLost();
			return false;
		}
	}

	public void playerWon() { //display win message
		System.out.println("**** ****");
		 //should display  with all values filled in
		System.out.println("Congratulations, You Won!");
	}

	public void playerLost() { //display lose message
		System.out.println(":'( :'( :'(");
		System.out.println(); //should display process()
		System.out.println("You Lost! You ran out of guesses.");
	}

	public void boolean askToPlayAgain() { //return boolean, if false leave while loop
		System.out.println("Would you like to play again? (yes/no)");
		if (scan.next().equalsIgnoreCase("no")) {
			return playGame = false;
		} else {
			return wordGuessed = false;
		}
	}

	public void runGame() { //pulls the methods written to run the game
		while (playGame) {
			this.announceGame();
			while(!wordGuessed) {

				System.out.println("Current Guesses: ");
				// current status goes here
				System.out.println("You have " + guessesLeft + " tries left");
				this.getNextGuess();
			}

		this.askToPlayAgain();
		}
		System.out.println("Game Over");
	}

	public static void main(String[] args) {
		WordGuess game = new WordGuess();
		game.runGame();

	}


}
