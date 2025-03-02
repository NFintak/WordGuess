//Nathan
import java.util.Arrays;
import java.util.Scanner;

public class WordGuess {
	java.util.Random randomGenerator = new java.util.Random();
	Scanner scan = new Scanner(System.in);
	String[] wordList = {"cat", "pie", "fork", "tree"};
	int randomNum = randomGenerator.nextInt(wordList.length);
	String keyword = wordList[randomNum];
	boolean playGame = true;
	char[] userGuesses;
	boolean wordGuessed = false;
	int guessesLeft;
	char letter;
	char[] keyArray;


	public void announceGame() { //welcome message
		System.out.println("Let's Play Wordguess version 1.0");
	}


	public void printArray() { //formats user guesses with spaces
		for (int i = 0; i < keyword.length(); i++) {
			System.out.print(userGuesses[i] + " ");
		}

	}

	public char[] initializeGameState() { //sets char array for secret word and guesses
		userGuesses = new char[keyword.length()];
		guessesLeft = keyword.length();
		keyArray = keyword.toCharArray();
		for (int i = 0; i < keyword.length(); i++) {
			userGuesses[i] = '_';
		}
		return userGuesses;
	}

	public char getNextGuess() { //returns player input for guess
		System.out.println("Enter a single character: ");
		String prompt = scan.next();
		letter = prompt.charAt(0);
		return letter;
	}

	public int printCurrentState() { //use printArray to show correct player guesses
		System.out.println("Current Guesses: ");
		if (!wordGuessed && guessesLeft > 0) {
			this.printArray();
		}
		System.out.println("You have " + guessesLeft + " tries left");
		guessesLeft--;
		return guessesLeft;
	}

	public char[] process() { //cycles thru word array and compares against input guess, replaces _ if correct
		for (int i = 0; i < keyword.length(); i++) {
			if (letter == keyArray[i] && userGuesses[i] == '_') {
				userGuesses[i] = letter;
				return userGuesses;
			} else {
				userGuesses[i] = '_';
				return userGuesses;
			}
		}
		return userGuesses;
	}

	public boolean isWordGuessed() { //return boolean, if true display win message
		if (guessesLeft <= 0 && !(Arrays.equals(userGuesses, keyArray))) {
			this.playerLost();
			return wordGuessed = false;
		} else if (guessesLeft <= 0 || !(Arrays.equals(userGuesses, keyArray))) {
			this.playerLost();
			return wordGuessed = false;
		} else {
			this.playerWon();
			return wordGuessed = true;
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

	public boolean askToPlayAgain() { //return boolean, if false leave while loop
		System.out.println("Would you like to play again? (yes/no)");
		if (scan.next().equalsIgnoreCase("no")) {
			return playGame = false;
		} else {
			return wordGuessed = false;
		}
	}

	public void gameOver() {
		System.out.println("Game over.");
	}

	public void runGame() { //pulls the methods written to run the game
		while (playGame) {
			this.announceGame();
			this.initializeGameState();
			while(!wordGuessed) {

				this.printCurrentState(); // current status goes here
				this.getNextGuess();
				this.process();
				this.isWordGuessed();
			}

		this.askToPlayAgain();
		}
		this.gameOver();
	}

	public static void main(String[] args) {
		WordGuess game = new WordGuess();
		game.runGame();

	}


}
