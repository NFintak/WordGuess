//Nathan
import java.util.Arrays;
import java.util.Scanner;

public class WordGuess {
	java.util.Random randomGenerator = new java.util.Random();
	Scanner scan = new Scanner(System.in);
	String[] wordList = {"cat", "pie", "fork", "tree"};
	int randomNum = randomGenerator.nextInt(wordList.length);
	String keyword = wordList[randomNum];;
	boolean playGame = true;
	char[] userGuesses = new char[keyword.length()];
	boolean wordGuessed;
	int guessesLeft = keyword.length();
	char letter;
	char[] keyArray = keyword.toCharArray();
	boolean playAgain = false;
	//keyword = wordList[randomNum];
	//userGuesses = new char[keyword.length()];
	//guessesLeft = keyword.length();
	//keyArray = keyword.toCharArray();
	/*
	class keyword {
		String word;
	}
	*/
	private void announceGame() { //welcome message
		System.out.println("Let's Play Wordguess version 1.0");
		playAgain = true;
	}

	private char[] initializeGameState() { //sets char array for secret word and guesses
		wordGuessed = false;
/*		if (playAgain && !wordGuessed) {
			keyword = wordList[randomNum];
			userGuesses = new char[this.keyword.length()];
			guessesLeft = this.keyword.length();
			keyArray = this.keyword.toCharArray();
		} */
		for (int i = 0; i < this.keyword.length(); i++) {
			userGuesses[i] = '_';
		}
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
		playAgain = false;
		System.out.println("Current Guesses: ");
		if (!wordGuessed && guessesLeft > 0) {
			this.printArray();
		}
		System.out.println("\nYou have " + guessesLeft + " tries left");
		return guessesLeft;
	}

	private char[] process(char letter) { //cycles thru word array and compares against input guess, replaces _ if correct
		for (int i = 0; i < keyword.length(); i++) {
			if (letter == keyArray[i] && userGuesses[i] == '_') {
				userGuesses[i] = letter;
			} // check if letter in keyword has been guessed
			//use setCharAt() for this part?
		}
		if (guessesLeft == 0 && !(Arrays.equals(userGuesses, keyArray))) {
			wordGuessed = false;
		} else if (Arrays.equals(keyArray, userGuesses) && guessesLeft > 0) {
			wordGuessed = true;
		}
		guessesLeft--;
		return userGuesses;
	}

	public void isWordGuessed(boolean playAgain) { //return boolean, if true display win message
		if (wordGuessed && guessesLeft >= 0) {
			this.playerWon();

		} else if (!wordGuessed && guessesLeft == 0) {
			this.playerLost();
		}
	}

	private boolean playerWon() { //display win message
		System.out.println("**** ****");
		System.out.println(userGuesses);
		System.out.println("Congratulations, You Won!");
		//this.askToPlayAgain();
		return wordGuessed = false;
	}

	private boolean playerLost() { //display lose message
		System.out.println(":'( :'( :'(");
		System.out.println(userGuesses);
		System.out.println("You Lost! You ran out of guesses.");
		//this.askToPlayAgain();
		return wordGuessed = true;
	}

	public boolean askToPlayAgain() { //return boolean, if false leave while loop
		System.out.println("Would you like to play again? (yes/no)");
		if (scan.next().equalsIgnoreCase("no")) {
			return playAgain = false;
		} else if (scan.next().equalsIgnoreCase("yes")){
			wordGuessed = false;
			return playAgain = true;
		} else {
			return playAgain = false;
		}
	}

	private void gameOver() {
		System.out.println("Game over.");

	}

	public void runGame() { //pulls the methods written to run the game
		this.announceGame();
		while (playGame == true) {
			while (playAgain == true) {
				this.initializeGameState();
				while (wordGuessed == false) { // and guesses more than zero
					this.printCurrentState(); // current status goes here
					this.getNextGuess();
					this.process(letter);
					this.isWordGuessed(wordGuessed);
				}
			this.askToPlayAgain();
			}

		}
		this.gameOver();
	}

	public static void main(String[] args) {
		WordGuess game = new WordGuess();
		game.runGame();

	}


}
