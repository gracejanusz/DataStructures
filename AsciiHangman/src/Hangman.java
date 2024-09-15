import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

/* 1. The toUpperCase method is necessary because it automatically makes the 
 * user's input into uppercase. In doing so, the user cannot make an error if they incorrectly
 * place a capital letter in the middle of their word. (ex. coDing != CODING) This supports the later functionality
 * of when taking the user input to make sure that it matches in spite of user error.
 * 2. We would need to change 
 * 		makeCenterPost();
		makeBeam();
		makeBase();
		makeRope();
	3.These lines would not produce the same code in every condition. The first line will put it alphabetically and then eliminate 
	adjacent lines that repeat, making a much more effective code. The second line would eliminate 
	adjacent repeating lines that are listed in the file, but since they are not alphabetically sorted until after the uniq comman
	is run, it is more likely that there will be repeating lines. Therefore the first code is more effective in eliminating all repeats.
	4. Because it is not neccesarrily used until the Man class, it is unnecesarry and harder to keep track of if it is not defined in 
	the man class or if it is difined in the other classes. There is no need to add extra code in places of which it is not needed.
 * 
 */



public class Hangman {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the ASCII Version of Hangman!");
		
		Console c = System.console();
		Scanner s = new Scanner(System.in);
		char[] letters;
		
		String prompt = "Please enter a secret word: ";
		if(c != null) {
			letters = c.readPassword(prompt);
			for(int i=0; i<letters.length; i++) {
				letters[i] = Character.toUpperCase(letters[i]);
			}
		} else {
			System.out.println("For best results, please run this from the command line.");
			System.out.print(prompt);
			letters = s.nextLine().trim().toUpperCase().toCharArray();
			for(int i=0; i<10000; i++) System.out.println();
		}

		Gallows g = new Gallows();
		boolean win = false;
		
		int numGuess = 0;
		boolean found = false;
		// making the secret word blank
		char[] secretWord = new char[letters.length];
				for(int i = 0; i< secretWord.length; i++) {
			secretWord[i] = '_';
		}
		//print gallows
			System.out.println();
			System.out.print(g.toString());
		
		
		// runs the game while user still alive and the word isn't found
		while(g.isAlive() && !win) {
			System.out.print("Puzzle to solve: ");
			for(int i= 0; i < secretWord.length; i++) {
				System.out.print(secretWord[i] + " ");
			}
			System.out.println();
			System.out.print("Please guess a letter: ");
			//the guess becomes a char and not case sensitive
			char guess = s.nextLine().toUpperCase().charAt(0);
		//show guess	
		System.out.println(guess);
		//checking to see if the guess matches a letter	
		for (int i=0; i<letters.length; i++) {
			if (letters[i] == guess) {
				//if a match is found
				found = true;
			for (int j = 0; j< letters.length; j++) {
				if (letters[j] == guess) {
					secretWord[j] = guess;
				}
			}
			//break
			break;
			} else {
				found = false;
			}
		}
		
		if (found == false) {
			System.out.println("");
			g.hang();
			System.out.print(g.toString());
		}
		
		//checks if you got all the letters
		// no more underscores = win
		numGuess = 0;
		for(int i = 0; i < secretWord.length; i++) {
			if(secretWord[i] != '_') {
				numGuess++;
			}
			if(numGuess == secretWord.length) {
				win = true;
			} else {
				win = false;
			}
		
		}
		
}
//prints which user won
	if(win) {
		System.out.println("Success!  Player 2 wins!");
	} else {
		System.out.println("Game over! Player 1 wins!");
			}
	s.close();
	}	
	
}
