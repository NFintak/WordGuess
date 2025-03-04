//Nathan
import java.util.Arrays;
import java.util.Scanner;

public class WordGuess {
	java.util.Random randomGenerator = new java.util.Random();
	Scanner scan = new Scanner(System.in);
	String[] wordList = {"cat", "pie", "fork", "tree"};
	int randomNum = randomGenerator.nextInt(wordList.length);
	String keyword = wordList[randomNum];;
	//boolean playGame = true;
	char[] userGuesses = new char[keyword.length()];
	boolean wordGuessed;
	int guessesLeft = keyword.length();
	char letter;
	char[] keyArray = keyword.toCharArray();
	boolean playAgain = true;
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
		//playAgain = true;
	}

	private char[] initializeGameState(char[] userGuesses) { //sets char array for secret word and guesses
		wordGuessed = false;
		//if (playAgain) {
		//keyword = wordList[randomNum];
		//userGuesses = new char[this.keyword.length()];
		//guessesLeft = this.keyword.length();
		//keyArray = this.keyword.toCharArray();
		//}
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

	private char[] printArray(/*char[] userGuesses*/) { //formats user guesses with spaces
		for (int i = 0; i < this.keyword.length(); i++) {
			System.out.print(userGuesses[i] + " ");
		}
		return userGuesses;
	}

	private int printCurrentState(int guessesLeft) { //use printArray to show correct player guesses
		playAgain = false;
		System.out.println("Current Guesses: ");
		if (!wordGuessed && guessesLeft > 0) {
			this.printArray(/*userGuesses*/);
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

	public void isWordGuessed() { //return boolean, if true display win message
		if (wordGuessed && guessesLeft >= 0) {
			this.playerWon(wordGuessed);
		} else if (!wordGuessed && guessesLeft == 0) {
			this.playerLost(wordGuessed);
		}
	}

	private boolean playerWon(boolean wordGuessed) { //display win message
		System.out.println("**** ****");
		System.out.println(userGuesses);
		System.out.println("Congratulations, You Won!");
		this.askToPlayAgain(playAgain);
		return wordGuessed = false;
	}

	private boolean playerLost(boolean wordGuessed) { //display lose message
		System.out.println(":'( :'( :'(");
		System.out.println(userGuesses);
		System.out.println("You Lost! You ran out of guesses.");
		this.askToPlayAgain(playAgain);
		return wordGuessed = true;
	}

	public boolean askToPlayAgain(boolean playAgain) { //return boolean, if false leave while loop
		System.out.println("Would you like to play again? (yes/no)");
		if (scan.next().equalsIgnoreCase("no")) {
			playAgain = false;
		} else if (scan.next().equalsIgnoreCase("yes")){
			playAgain = true;
		} else {
			playAgain = false;
		}
		return playAgain;
	}

	private void gameOver() {
		System.out.println("Game over.");

	}

	public void runGame() { //pulls the methods written to run the game
		this.announceGame();
			while (playAgain == true) {
				initializeGameState(userGuesses);
				while (wordGuessed == false) { // and guesses more than zero
					this.printCurrentState(guessesLeft); // current status goes here
					this.getNextGuess();
					this.process(letter);
					this.isWordGuessed();
				}
			askToPlayAgain(playAgain);
			}
		gameOver();
	}

	public static void main(String[] args) {
		WordGuess game = new WordGuess();
		game.runGame();

	}


}
