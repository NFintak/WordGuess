//Nathan
import java.util.Arrays;
import java.util.Scanner;

public class WordGuess {
	java.util.Random randomGenerator = new java.util.Random();
	Scanner scan = new Scanner(System.in);
	boolean playAgain;
	String[] wordList = {"cat", /*"pie", "fork",*/ "tree"};
	int randomNum = randomGenerator.nextInt(wordList.length);
	String keyword = wordList[randomNum];
	char[] userGuesses = new char[keyword.length()]; //make empty array
	boolean wordGuessed;
	int guessesLeft = keyword.length();
	char letter;
	char[] keyArray = keyword.toCharArray();

	//keyword = wordList[randomNum];
	//userGuesses = new char[keyword.length()];
	//guessesLeft = keyword.length();
	//keyArray = keyword.toCharArray();
	/*
	class keyword {
		String word;
	}
	*/
	public void announceGame() { //welcome message
		System.out.println("Let's Play Wordguess version 1.0");
		//playAgain = true;
	}

	public char[] initializeGameState() { //sets char array for secret word and guesses
		keyword = wordList[randomNum];
		userGuesses = new char[this.keyword.length()];
		guessesLeft = this.keyword.length();
		keyArray = this.keyword.toCharArray();
		for (int i = 0; i < this.keyword.length(); i++) {
			userGuesses[i] = '_';
		}
		return userGuesses;
	}

	public char getNextGuess() { //returns player input for guess
		System.out.println("Enter a single character: ");
		String prompt = scan.nextLine();
		letter = prompt.charAt(0);
		return letter;
	}

	public char[] printArray(/*char[] userGuesses*/) { //formats user guesses with spaces
		for (int i = 0; i < this.keyword.length(); i++) {
			System.out.print(userGuesses[i] + " ");
		}
		return userGuesses;
	}

	public int printCurrentState() { //use printArray to show correct player guesses
		System.out.println("Current Guesses: ");
		if (!wordGuessed && guessesLeft > 0) {
			this.printArray(/*userGuesses*/);
		}
		System.out.println("\nYou have " + guessesLeft + " tries left");
		return guessesLeft;
	}

	public char[] process() { //cycles thru word array and compares against input guess, replaces _ if correct
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

	public void isWordGuessed() { //return boolean, if true display win message
		if (wordGuessed && guessesLeft >= 0) {
			playerWon();
		} else if (!wordGuessed && guessesLeft == 0) {
			playerLost();
		}
	}

	public void /*boolean*/ playerWon() { //display win message
		System.out.println("**** ****");
		System.out.println(userGuesses);
		System.out.println("Congratulations, You Won!");
		//return wordGuessed = false;
	}

	public void /*boolean*/ playerLost() { //display lose message
		System.out.println(":'( :'( :'(");
		System.out.println(userGuesses);
		System.out.println("You Lost! You ran out of guesses.");
		//return wordGuessed = true;
	}

	public boolean askToPlayAgain() { //return boolean, if false leave while loop
		System.out.println("Would you like to play again? (yes/no)");
		String tryAgain = scan.nextLine();
		if (tryAgain.equalsIgnoreCase("no")) {
			return playAgain = false;
		} else if (tryAgain.equalsIgnoreCase("yes")){
			return playAgain = true;
		} else {
			return playAgain = false;
		}
	}

	public void gameOver() {
		System.out.println("Game over.");

	}

	public void runGame() { //pulls the methods written to run the game
		playAgain = true;
		this.announceGame();
		while (playAgain == true) {
			initializeGameState();
			wordGuessed = false;
			while (wordGuessed == false) { // and guesses more than zero
				printCurrentState(); // current status goes here
				getNextGuess();
				process();
				isWordGuessed();
			}
			askToPlayAgain();
		}
		gameOver();
	}

	public static void main(String[] args) {
		WordGuess game = new WordGuess();
		game.runGame();

	}


}