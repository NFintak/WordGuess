//Nathan
import java.util.Arrays;
import java.util.Scanner;

public class WordGuess {
	java.util.Random randomGenerator = new java.util.Random();
	Scanner scan = new Scanner(System.in);
	String[] wordList = {"cat", "pie", "fork", "tree"};
	int randomNum = randomGenerator.nextInt(wordList.length);
	String keyword;
	boolean playGame = true;
	char[] userGuesses;
	boolean wordGuessed;
	int guessesLeft;
	char letter;
	char[] keyArray;
	boolean playAgain = false;
	/*
	class keyword {
		String word;
	}
	*/
	private void announceGame() { //welcome message
		System.out.println("Let's Play Wordguess version 1.0");
	}

	private char[] initializeGameState() { //sets char array for secret word and guesses
		keyword = wordList[randomNum];
		wordGuessed = false;
		//if (playAgain && !wordGuessed) {

		//}
		userGuesses = new char[this.keyword.length()];
		guessesLeft = this.keyword.length();
		keyArray = this.keyword.toCharArray();
		for (int i = 0; i < this.keyword.length(); i++) {
			userGuesses[i] = '_';
		}
		//use setCharAt() for this part?
		return userGuesses;
	}

	private char getNextGuess() { //returns player input for guess
		System.out.println("Enter a single character: ");
		String prompt = scan.nextLine();
		letter = prompt.charAt(0);
		return letter;
	}

	private char[] printArray() { //formats user guesses with spaces
		for (int i = 0; i < this.keyword.length(); i++) {
			System.out.print(userGuesses[i] + " ");
		}

		return userGuesses;
	}

	private int printCurrentState() { //use printArray to show correct player guesses
		System.out.println("Current Guesses: ");
		if (!wordGuessed && guessesLeft > 0) {
			this.printArray();
		}
		return guessesLeft;
	}

	private char[] process(char letter) { //cycles thru word array and compares against input guess, replaces _ if correct
		System.out.println("You have " + guessesLeft + " tries left");
		for (int i = 0; i < keyword.length(); i++) {
			if (letter == keyArray[i] && userGuesses[i] == '_') {
				userGuesses[i] = letter;
			} // check if key word has been guessed or if user is out of guesses
			//use setCharAt() for this part?
		}
		if (guessesLeft == 0 && !(Arrays.equals(userGuesses, keyArray))) {
			wordGuessed = false;
		} else if (Arrays.equals(keyArray, userGuesses) && guessesLeft > 0) {
			wordGuessed = true;
		} else {
			wordGuessed = false;
		}
		return userGuesses;
	}

	private boolean isWordGuessed(boolean wordGuessed, boolean playGame) { //return boolean, if true display win message
		if (wordGuessed && guessesLeft >= 0) {
			this.playerWon();
		} else if (!wordGuessed && guessesLeft == 0) {
			this.playerLost();
		}
		guessesLeft--;
		return playGame;
	}

	private void playerWon() { //display win message
		System.out.println("**** ****");
		System.out.println(userGuesses);
		System.out.println("Congratulations, You Won!");
	}

	private void playerLost() { //display lose message
		System.out.println(":'( :'( :'(");
		System.out.println(userGuesses);
		System.out.println("You Lost! You ran out of guesses.");
	}

	private boolean askToPlayAgain() { //return boolean, if false leave while loop
		System.out.println("Would you like to play again? (yes/no)");
		if (scan.next().equalsIgnoreCase("no")) {
			return playGame = false;
		} else if (scan.next().equalsIgnoreCase("yes")){
			this.initializeGameState();
			playGame = true;
			playAgain = true;
			return wordGuessed;
		} else {
			return playGame = false;
		}
	}

	private void gameOver() {
		System.out.println("Game over.");

	}

	public void runGame() { //pulls the methods written to run the game
		this.initializeGameState();
		while (playGame == true) {
			this.announceGame();
			while(wordGuessed == false && guessesLeft > 0) { // and guesses more than zero

				this.printCurrentState(); // current status goes here
				this.getNextGuess();
				this.process(letter);
				this.isWordGuessed(wordGuessed, playGame);
			}
		}
		this.gameOver();
	}

	public static void main(String[] args) {
		WordGuess game = new WordGuess();
		game.runGame();

	}


}
