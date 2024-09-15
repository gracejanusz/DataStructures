import java.io.Console;
import java.util.Scanner;
//This extension creates a special animation if the user guesses the word correctly
//
public class Extension {
	public static void main(String[] args) throws InterruptedException {
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
	
		// make it look nicer
		System.out.println("**************************************");
		//print gallows
		System.out.println(g.toString());
		
		
		// runs the game while user still alive and the word isn't found
		while(g.isAlive() && !win) {
			System.out.print("Secret word: ");
			for(int i= 0; i < secretWord.length; i++) {
				System.out.print(secretWord[i] + " ");
			}
			System.out.println(" ");
			System.out.println("Guess a letter");
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
//special dance up ahead
	if(win) {
			while (true) {
				System.out.println("       ");
				System.out.println("   0   ");
				System.out.println("  \\|/  ");
				System.out.println("  / \\   ");
				System.out.println("       "); 
				System.out.println("       "); 
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				
				System.out.println("   _   ");
				System.out.println("   0   ");
				System.out.println("  \\|/  ");
				System.out.println("  / \\   ");
				System.out.println("       ");
				System.out.println("       "); 
				
				Thread.sleep(100);
				
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
			
				
				System.out.println("  ___  ");
				System.out.println("   0   ");
				System.out.println("  \\|/  ");
				System.out.println("  / \\   ");
				System.out.println("       ");
				System.out.println("       "); 
				
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
			
				
				System.out.println(" _____ ");
				System.out.println("   0   ");
				System.out.println("  \\|/  ");
				System.out.println("  / \\   ");
				System.out.println("       ");
				System.out.println("       "); 
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				
				
				System.out.println(" _____ ");
				System.out.println("|  0  |");
				System.out.println("  \\|/  ");
				System.out.println("  / \\   ");
				System.out.println("       ");
				System.out.println("       "); 
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				
				
				System.out.println(" _____ ");
				System.out.println("|  0  |");
				System.out.println("| \\|/ |");
				System.out.println("  / \\  ");
				System.out.println("       ");
				System.out.println("       ");
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				
				
				System.out.println(" _____ ");
				System.out.println("|  0  |");
				System.out.println("| \\|/ |");
				System.out.println("| / \\ |");
				System.out.println("       ");
				System.out.println("       ");
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				
				System.out.println(" _____ ");
				System.out.println("|  0  |");
				System.out.println("| \\|/ |");
				System.out.println("| / \\ |");
				System.out.println("|_   _|");
				System.out.println("       ");
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				
				System.out.println(" _____ ");
				System.out.println("|  0  |");
				System.out.println("| \\|/ |");
				System.out.println("| / \\ |");
				System.out.println("|__ __|");
				System.out.println("       ");
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				
				
				System.out.println(" _____ ");
				System.out.println("|  0  |");
				System.out.println("| \\|/ |");
				System.out.println("| / \\ |");
				System.out.println("|_____|");
				System.out.println("       ");
				
				Thread.sleep(100);
				
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				System.out.println("       ");
				
				
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("P      "); 
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PL     "); 
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLA    "); 

					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAY   "); 
					
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAYE  "); 
					
					Thread.sleep(100);
					
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAYER "); 
					
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAYER 1  "); 
					
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAYER 1 W "); 
					
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAYER 1 WI "); 
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAYER 1 WIN "); 
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAYER 1 WINS"); 
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					
					System.out.println(" _____ ");
					System.out.println("|  0  |");
					System.out.println("| \\|/ |");
					System.out.println("| / \\ |");
					System.out.println("|_____|");
					System.out.println("PLAYER 1 WINS"); 
					
					Thread.sleep(100);
					
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					

			}					
		

	} else {
		System.out.println("Game over! You lost.");
		System.out.print("The Secret word was... ");
		System.out.println(letters);
	}	
s.close();
	}
	
}
		