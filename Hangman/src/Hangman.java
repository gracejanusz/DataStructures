//Extension: I added another Man to the end to congratulate the player if they win. I also
//added two methods: winnerGuy, which shows the little drawing, and hideLittleGuy, which hides him.
/*Thought Questions:
 * 1. onMouseEnters, invokes a code when the mouse enters the windows canvas. onMouseExits is used to invoke when the mouse exits the 
 * canvas. This could be implemented in a code where something has to be following the mouse. Perhaps a cat and mouse type game(pun intended), where 
 * if the mouse/cursor is on the screen, the cat follows it in an attempt to catch the mouse. It could also be used to invoke some pause/play
 * button when the mouse enters the canvas. Kind of like a netflix player where if you hover over the screen, it shows a pause/play button.
 * 2.The objectDraw.Rect class is most likely an abstract class, which indicates that holds the methods that are not implemented in 
 * the base class. In this case, objectdraw.Rect will have methods that get and set bounds for the Rectangles, along with height and width. 
 * This class is the implementation behind why the user can say FilledRect fr = new FilledRect(int x, int y, int z, int a, canvas) and it 
 * creates a new filled Rectangle. It's main constructors tell the user what the format is for constructing a new object.
 * 3. The removeFromCanvas, permanantly removes the object that the user is intending to from the canvas. While the hide() method temporarily 
 * hides the object from the canvas. When a user is going to want an object that can be hidden and shown more than once, the user should use \
 * hide and show methods. If the user wants to display an object, then hide it permanantly, the removeFromCanvas is more useful, as it
 * preserves future space by removing the object.
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import objectdraw.*;
public class Hangman extends WindowController  implements KeyListener{

	protected String word = "";
	protected char[] letters;
	protected char[] puzzleLetters;
	protected boolean setup;
	protected int lettersRemaining;
	protected int playerNum = 0;
	private String secretWord = " ";
	
	// GUI Elements
	protected Text label;
	protected Text buttonText;
	protected FramedRect button;
	protected Text puzzle;
	protected Gallows gallows;
	protected Text message;
	
	protected static final int WINDOW_SIZE = 600;
	protected static final int TEXT_OFFSET = 10;
	protected static final int PUZZLE_OFFSET = 120;
	protected static final int BUTTON_WIDTH = 200;
	protected static final int BUTTON_HEIGHT = 40;

	
    public void begin()
    {
            // Get ready to handle key focuses
            requestFocus();
            addKeyListener(this);
            canvas.addKeyListener(this);
            // Set up the GUI for Player to enter the target word.
            label = new Text("Player " + getPlayerNum() + ", please enter a word.", TEXT_OFFSET, TEXT_OFFSET, canvas);
            label.setFontSize(20);
            message = new Text("Good Job!", 150, 200, canvas); 
            message.setFontSize(18);
            message.hide();
            gallows = new Gallows(WINDOW_SIZE/4.0, WINDOW_SIZE * 2.0/3, canvas);
            gallows.clear();
            setup = true;
            button = new FramedRect(
            		WINDOW_SIZE/2 - BUTTON_WIDTH/2,
            		WINDOW_SIZE/2 - BUTTON_HEIGHT,
            		BUTTON_WIDTH,
            		BUTTON_HEIGHT,
            		canvas);
            button.setColor(Color.BLUE);
            button.hide();
            
            buttonText = new Text("Click when finished.", 
            		button.getX() + BUTTON_WIDTH/2, 
            		button.getY() + BUTTON_HEIGHT/2, 
            		canvas);
            buttonText.move(buttonText.getWidth()/-2.0, buttonText.getHeight()/-2.0);
            buttonText.hide();
            
            puzzle = new Text("Secret Word is: ", WINDOW_SIZE/2, WINDOW_SIZE - PUZZLE_OFFSET, canvas);
            puzzle.setFontSize(30);
    		puzzle.moveTo(WINDOW_SIZE/2-puzzle.getWidth()/2, puzzle.getY());

    }
 
    
    // Required by KeyListener Interface.
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e)
    {
    	if(setup) {
    		message.hide();
    		gallows.hideLittleGuy();
    		if(word.isEmpty()) puzzle.setText("Secret Word is: ");
    		char letter = Character.toUpperCase(e.getKeyChar());
    		if (Character.isLetter(letter)) {
	    		/* TODO: Update the puzzle text with the letter
	    		 * that was just entered.
	    		 */
    			//add letter to word
    			word+= String.valueOf(letter);
    			//set secretWord to blanks, add line for each letter
    			secretWord = "";
    			for(int i=0; i<word.length(); i++) {
    				secretWord += "_ ";
    			}
    			puzzle.setText("Secret Word is: "+ secretWord);
    			//display new puzzle
	    		puzzle.moveTo(WINDOW_SIZE/2-puzzle.getWidth()/2, puzzle.getY());
	    		if(word.length() == 1) {
	    			button.show();
	    			buttonText.show();	
	    		}
    		} else if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE && ! word.isEmpty()) {
    			/* TODO: Add logic to process the delete key having 
    			 * been pressed, adjusting the possition of the puzzle
    			 * text accordingly.  Hide the "Click when finished" button 
    			 * if the word has been deleted entirely. 
    			 */
    			word = word.substring(0,word.length()-1);
    			//new word
    			secretWord = "";
    			for(int i=0; i<word.length(); i++) {
    				secretWord += "_ ";
    			}
    			puzzle.setText("Secret Word is: "+ secretWord);
    			//display new puzzle
	    		puzzle.moveTo(WINDOW_SIZE/2-puzzle.getWidth()/2, puzzle.getY());
				//clears the button
	    		if(word.isEmpty()) {
	    		button.hide();
	    		buttonText.hide();
	    		}
    			
    		}
    	} else if (gallows.isAlive() ){ 
    		char guessedLetter = Character.toUpperCase(e.getKeyChar());
    		/* TODO: Add logic to check if the letter
    		 * is in the word. Update the guess word
    		 * if the letter is found, otherwise hang
    		 * the man.
    		 */
    		//guesses if letter in word
    			if (word.indexOf(guessedLetter) >= 0) {
    			//update the word if the letters are in
    				updateGuessWord(guessedLetter);
    			} else {
    				//if letter not in, hang
    				gallows.hang();
    			}
    		
    		//when all the man hasn't been hanged
    		if(gallows.isAlive()) {
    			secretWord = "";
    			//print the secret word to guessed letters
    			for(int i=0; i<puzzleLetters.length; i++) {
    				secretWord += puzzleLetters[i];
    				secretWord += " ";
    			}
    			//reprint secret word
    			puzzle.setText("Secret Word is: "+ secretWord);	
    			} else {
    				//when the player loses
    
    				label.setText("Game over! Player " + getPlayerNum() + " wins.");
    				secretWord = "";
    				for (int i = 0; i < letters.length; i++) {
    					secretWord += Character.toLowerCase(letters[i]);
    				}
        				puzzle.setText("The Word was: " + secretWord );
    			}
    				
    		}
    		
    }
    
    public void onMousePress(Location point) {
    	if (button.contains(point) && !button.isHidden() && ! word.isEmpty()) {
    		/* TODO:  Add logic to exit setup mode and
    		 * start gameplay
    		 */
    		setup=false;
    		lettersRemaining = word.length();
    		buttonText.hide();
    		button.hide();
    		getPlayerNum();
    		//player 2 turn
    		label.setText("Player " + getPlayerNum() + ", please type a key to guess a "
    	            + "letter");
    		label.setFontSize(18);
    		//show gallows
    		gallows = new Gallows(WINDOW_SIZE/4.0, WINDOW_SIZE * 2.0/3, canvas);
    	//initialize & set secretWord
    		letters = word.toCharArray();
    		//set to underscore
    		puzzleLetters = new char[letters.length];
    		for(int i=0; i<letters.length; i++) {
				puzzleLetters[i] = '_';
    		
    	}
    	}
    }
    
    public int getPlayerNum() {
    	return playerNum + 1;
    }
	
  
    
    public void updateGuessWord(char guessedLetter) {
    	/* TODO:  Add logic to update the guessed word.
    	 * Also include logic to test if the puzzle has
    	 * been solved (allowing the user to enter a new
    	 * word for their opponent if the puzzle is complete). 
    	 */	
    	//lettersRemaining = 0;
    	for (int i = 0; i < puzzleLetters.length; i++) {
			if (letters[i] == guessedLetter) {
				puzzleLetters[i] = guessedLetter;
				lettersRemaining--;
			}
    	}
			if (lettersRemaining == 0) {
	    		// clear gallows
	    		gallows.clear();
	    		gallows.winnerGuy();
	    		//label at the top
	    		label.setText("Congratulations! You solved the puzzle. Enter a new word.");
	    		message.show();
	    	
	    		//setup true so user can enter new word
	            setup = true;
	            //make word empty
	            word = "";
		}
    }
    
    public static void main(String[] args) { 
        new Hangman().startController(WINDOW_SIZE, WINDOW_SIZE); 
        
	}
	
}
