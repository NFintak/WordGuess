//Nathan
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class WordGuess {
	Random randomGenerator = new java.util.Random();
	Scanner scan = new Scanner(System.in);
	boolean playAgain;
	String[] wordList = {"cat", "pie", "fork", "tree"}; //leave this as an array
	int randomNum = randomGenerator.nextInt(wordList.length);
	String keyword;
	ArrayList<Character> userGuesses = new ArrayList<>();
	boolean wordGuessed;
	int guessesLeft;
	char letter;
	ArrayList<Character> keyArray = new ArrayList<>();

	/*
	class keyword {
		String word;
	}
	*/
	public void announceGame() { //welcome message
		System.out.println("Let's Play Wordguess version 1.0");
	}

	public ArrayList<Character> initializeGameState() { //sets char array for secret word and guesses
		keyword = wordList[randomNum];
		guessesLeft = keyword.length();
		for (int i = 0; i < keyword.length(); i++) {
			userGuesses.add('_');
			keyArray.add(keyword.charAt(i));
		}

		return userGuesses;
	}

	public char getNextGuess() { //returns player input for guess
		System.out.println("Enter a single character: ");
		String prompt = scan.nextLine();
		letter = prompt.charAt(0);
		return letter;
		//return 'z';
	}

	public void printArray() { //formats user guesses with spaces
		for (int i = 0; i < this.keyword.length(); i++) {
			System.out.print(userGuesses.get(i) + " ");
		}
	}

	public void printCurrentState() { //use printArray to show correct player guesses
		System.out.println("Current Guesses: ");
		if (!wordGuessed && guessesLeft > 0) {
			this.printArray();
		}
		System.out.println("\nYou have " + guessesLeft + " tries left");

	}

	public ArrayList<Character> process() { //cycles thru word array and compares against input guess, replaces _ if correct
		for (int i = 0; i < keyword.length(); i++) {
			if (letter == keyArray.get(i) && userGuesses.get(i) == '_') {
				userGuesses.set(i, letter);
			} // check if letter in keyword has been guessed
		}
		if (guessesLeft == 0 && !(Arrays.equals(userGuesses.toArray(), keyArray.toArray()))) {
			wordGuessed = false;
		} else {
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

	public void playerWon() { //display win message
		System.out.println("**** ****");
		System.out.println(userGuesses);
		System.out.println("Congratulations, You Won!");

	}

	public void playerLost() { //display lose message
		System.out.println(":'( :'( :'(");
		System.out.println(userGuesses);
		System.out.println("You Lost! You ran out of guesses.");
	}

	public boolean askToPlayAgain() { //return boolean, if false leave while loop
		System.out.println("Would you like to play again? (yes/no)");
		String tryAgain = scan.nextLine();
		if (tryAgain.equalsIgnoreCase("no")) {
			return playAgain = false;
		} else if (tryAgain.equalsIgnoreCase("yes")){
			keyArray.clear();
			userGuesses.clear();
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
		while (playAgain) {
			initializeGameState();
			wordGuessed = false;
			while (!wordGuessed) { // and guesses more than zero
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