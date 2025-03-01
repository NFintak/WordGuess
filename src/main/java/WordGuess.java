//Nathan
import java.util.Scanner;

public class WordGuess {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //make scanner
		String keyword = "pie"; //need to convert letters to chars
		int startingNum = 4;

		System.out.println("Let's Play Wordguess version 1.0"); //starting message

		while (startingNum > 0) {
			System.out.println("Current Guesses: ");
			System.out.println("Enter a single character: ");
			String guess = scan.nextLine(); //need to change to char
			for (int i = 0; i <= (keyword.length() - 1); i++) {
				//check guess against chars in keyword
			}
			startingNum--;
			System.out.println("You have " + startingNum + "tries left.");
		}
	}
}