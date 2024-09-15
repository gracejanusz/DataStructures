import objectdraw.*;

public class Man {
	protected FramedOval head;
	protected DrawableInterface[] bodyParts;
	protected DrawableInterface[] winner;
	
	protected static final int MAX_INCORRECT = 6;
	protected static final int HEAD_SIZE = 80;
	protected static final int BODY_SIZE = 80;
	protected static final int ARM_LENGTH = 50;
	protected int numIncorrect;

	public Man(double xPos, double yPos, DrawingCanvas canvas) {
		/* TODO: Initialize all of the man's body parts.
		 * Then, use the clear method to hide them all. 
		 * The given (xPos, yPos) specifies the coordinates
		 * for the top of the man's head
		 */
	bodyParts = new DrawableInterface[6];
	head = new FramedOval(xPos,yPos,HEAD_SIZE,HEAD_SIZE, canvas);
	bodyParts[0] = head;
	//body
	bodyParts[1] = new Line( xPos +40 , yPos+ HEAD_SIZE , xPos +40, yPos+HEAD_SIZE +BODY_SIZE , canvas);
	//left arm
	bodyParts[2] = new Line(xPos+ HEAD_SIZE/2, yPos + HEAD_SIZE + 40, xPos+ HEAD_SIZE/2 - 50, yPos+ HEAD_SIZE+10, canvas);
	//right arm
	bodyParts[3] = new Line(xPos + HEAD_SIZE/2, yPos + HEAD_SIZE + 40, xPos+ HEAD_SIZE/2 + 50, yPos+ HEAD_SIZE+ 10, canvas);
	
	bodyParts[4] = new Line(xPos + HEAD_SIZE/2,yPos+ HEAD_SIZE + BODY_SIZE, xPos+ HEAD_SIZE/2 +(ARM_LENGTH*Math.cos(45)) , yPos+ HEAD_SIZE + BODY_SIZE+(ARM_LENGTH*Math.sin(45)), canvas);
	bodyParts[5] = new Line(xPos + HEAD_SIZE/2,yPos+ HEAD_SIZE + BODY_SIZE, xPos+ HEAD_SIZE/2-(ARM_LENGTH*Math.cos(45)) , yPos+ HEAD_SIZE + BODY_SIZE+(ARM_LENGTH*Math.sin(45)), canvas);
	
	//Added a little man to the end for a surprise.
	winner = new DrawableInterface[13];
	winner[0] = head;
	winner[1] = new Line( xPos +40 , yPos+ HEAD_SIZE , xPos +40, yPos+HEAD_SIZE +BODY_SIZE , canvas);
	//left arm
	winner[2] = new Line(xPos+ HEAD_SIZE/2, yPos + HEAD_SIZE + 40, xPos+ HEAD_SIZE/2 - 50, yPos+ HEAD_SIZE+10, canvas);
	//right arm
	winner[3] = new Line(xPos + HEAD_SIZE/2, yPos + HEAD_SIZE + 40, xPos+ HEAD_SIZE/2 + 50, yPos+ HEAD_SIZE+ 10, canvas);
	winner[4] = new Line(xPos + HEAD_SIZE/2,yPos+ HEAD_SIZE + BODY_SIZE, xPos+ HEAD_SIZE/2 +(ARM_LENGTH*Math.cos(45)) , yPos+ HEAD_SIZE + BODY_SIZE+(ARM_LENGTH*Math.sin(45)), canvas);
	winner[5] = new Line(xPos + HEAD_SIZE/2,yPos+ HEAD_SIZE + BODY_SIZE, xPos+ HEAD_SIZE/2-(ARM_LENGTH*Math.cos(45)) , yPos+ HEAD_SIZE + BODY_SIZE+(ARM_LENGTH*Math.sin(45)), canvas);
	winner[6] = new Line(xPos, yPos, xPos+HEAD_SIZE,yPos, canvas);
	winner[7] = new Line(xPos +20, yPos, xPos+20,yPos-40, canvas);
	winner[8] = new Line(xPos +60, yPos, xPos+60,yPos-40, canvas);
	winner[9] = new Line(xPos +20, yPos-40, xPos+60,yPos-40, canvas);
	winner[10] = new FilledOval(xPos +20,yPos+30,10,10, canvas);
	winner[11] = new FilledOval(xPos +50,yPos+30,10,10, canvas);
	winner[12] = new FilledOval(xPos +35,yPos+50,10,10, canvas);

	
	this.clear();
	this.hideLittleGuy();
	
	}
	public void clear() {
		/* TODO: Hide all of the man's body parts */
		for(int i=0; i <bodyParts.length; i++) {
			bodyParts[i].hide();
		
			
		}
			
		
			
	}
	//hides the little guy automatically
	public void hideLittleGuy() {
		for(int i=0; i <winner.length; i++) {
			winner[i].hide();
		}
	}
	//shows it when method is called in hangman class
	public void winnerGuy() {
		//shows the little guy happy for you winning
		for(int i=0; i < winner.length;i++) {
			winner[i].show();
		}
	}
	
	public void hang() {
		/* TODO: Hang the man */
		//from last hangman
		bodyParts[numIncorrect].show();
		numIncorrect++;
	}
	
	public boolean isAlive() {
		/* TODO: Return true if the man is not fully
		 * hanged.  Otherwise, return false. 
		 */
		return (numIncorrect<MAX_INCORRECT);
	}
	
}
