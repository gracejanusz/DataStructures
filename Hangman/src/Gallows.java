import objectdraw.*;

public class Gallows {

	protected FilledRect base;
	protected FilledRect beam;
	protected FilledRect crossbeam;
	protected FilledRect rope;
	protected Man man;
	
	protected static final int BEAM_WIDTH =10;

	
	public Gallows(double xPos, double yPos, DrawingCanvas canvas)
	{
		/* TODO: Initialize the instance variables that constitute the 
		 * frame of the gallows. The given (xPos, yPos) specifies the
		 * coordinates of the bottom left corner of the gallows.  
		 */
		man = new Man(xPos + BEAM_WIDTH * 16, yPos - BEAM_WIDTH * 25, canvas);
		//rope
	 rope = new FilledRect(xPos +75+125 , yPos -300 , 3,50, canvas);
	 //crossbeam
	 crossbeam = new FilledRect(xPos + 75, yPos-300, 125, 7, canvas);
	 //beam
	 beam = new FilledRect(xPos +75, yPos - 300,BEAM_WIDTH, 300, canvas);
	 //base
	 base = new FilledRect(xPos, yPos, 150, 5, canvas);
	}
	
	public void hang() {
		man.hang();
	}
	
	public boolean isAlive() {
		return man.isAlive();
	}
	
	public void hideLittleGuy() {
		man.hideLittleGuy();
	}
	
	public void winnerGuy() {
		man.winnerGuy();
	}
	public void clear() {
		/* TODO: Hide all of the elements of the 
		 * gallows, and clear the man.
		 */
		base.hide();
		beam.hide();
		crossbeam.hide();
		rope.hide();
		man.clear();
			
		}
		
	}

