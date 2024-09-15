import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import objectdraw.*;

/*Thought Questions:
 * 1. When graphed, the two functions intersect at n=0.001 and n=29. This means that a<b when 
 * 0.001<n<29.
 * 
 * 2. String concatenation is O(n) time because since java strings are immutable,
 * each times to add a string object to a new string , a new array is made with size of 
 * the two strings being concatenated then it copies each string letter into the correct
 *  space of the array and then it's toString method is called making the new concatenated 
 *  string. This takes O(n) time because it takes O(n+n) aka O(2n) therefore ultimately running
 *  in O(n) time.
 * 
 * 3. public static String toBinary(int number){
  if(number > 0) {
      toBinary(number / 2);
      toBinary((number % 2 ));
     }

   return toBinary((number));
}
 */




/*
 * A very simple drawing program.
 */
public class Scribbler extends WindowController
implements ActionListener {

  // User modes for what operation is selected.
  // We are using ints rather than boolean to allow for extension to
  // other modes
  private static final int DRAWING = 1;
  private static final int MOVING = 2;
  private static final int COLORING = 3;

  // the current scribble
  private ScribbleInterface currentScribble;

  // the collection of scribbles
  private ScribbleCollectionInterface scribbles;
 
  //collection of erased scribbles
  private ScribbleCollectionInterface erasedScribbles;

  // stores last point for drawing or dragging
  private Location lastPoint;
  
  //scribble that is selected
  private ScribbleInterface selectedScribble;

  // whether the most recent scribble has been selected for moving
  private boolean draggingScribble;

  // buttons that allow user to select modes
  private JButton setDraw, setMove, setErase, setColor, setUndo;

  // Choice JButton to select color
  private JComboBox chooseColor;


  // label indicating current mode
  private JLabel modeLabel;

  // the current mode -- drawing mode by default
  private int chosenAction = DRAWING;

  // create and hook up the user interface components
  public void begin() {

    setDraw = new JButton("Draw");
    setMove = new JButton("Move");
    setColor = new JButton("Color");

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(setDraw);
    buttonPanel.add(setMove);
    buttonPanel.add(setColor);

    chooseColor = new JComboBox();
    chooseColor.addItem("red");
    chooseColor.addItem("blue");
    chooseColor.addItem("green");
    chooseColor.addItem("yellow");

    setErase = new JButton("Erase last");
    JPanel choicePanel = new JPanel();
    choicePanel.add(setErase);
    //undo erase
    setUndo = new JButton("Undo erase");
    choicePanel.add(setUndo);
    choicePanel.add(chooseColor);

    JPanel controlPanel = new JPanel(new GridLayout(3,1));
    modeLabel = new JLabel("Current mode: drawing");
    controlPanel.add(modeLabel);
    controlPanel.add(buttonPanel);
    controlPanel.add(choicePanel);

    Container contentPane = this.getContentPane();
    contentPane.add(controlPanel, BorderLayout.SOUTH);

    // add listeners
    setDraw.addActionListener(this);
    setMove.addActionListener(this);
    setErase.addActionListener(this);
    setColor.addActionListener(this);
    setUndo.addActionListener(this);

    //add listener to choosecolor
    chooseColor.addActionListener(this);

    // make the current scribble empty
    currentScribble = new EmptyScribble();
    //make scribbles empty
    scribbles = new EmptyScribbleCollection();
    //make erased scribbles empty
    erasedScribbles=new EmptyScribbleCollection();
    

    this.validate();
  }

  /*
   * If in drawing mode then start with empty scribble.
   * If in moving mode then prepare to move.
   */
  public void onMousePress(Location point) {
    if (chosenAction == DRAWING) {
      // start with an empty scribble for drawing
      currentScribble = new EmptyScribble();

    } else if (chosenAction == MOVING) {
      // check if user clicked on current scribble
      draggingScribble = currentScribble.contains(point);
    }
    
    else if(chosenAction == COLORING) {
    	selectedScribble = scribbles.scribbleSelected(point);
    	//check for scribble
    	if(selectedScribble != null) {
    		selectedScribble.setColor((String) chooseColor.getSelectedItem());
    	}
    }

    // remember point of press for drawing or moving
    lastPoint = point;
  }

  /*
   * If in drawing mode, add a new segment to scribble.
   * If in moving mode then move it.
   */
  public void onMouseDrag(Location point) {
    if (chosenAction == DRAWING) {
      // add new line segment to current scribble
      Line newSegment = new Line(lastPoint, point, canvas);

      currentScribble =
      new NonEmptyScribble(newSegment, currentScribble);
    } else if (chosenAction == MOVING) {
      if (draggingScribble) {
        // move current scribble
        currentScribble.move(point.getX() - lastPoint.getX(),
          point.getY() - lastPoint.getY());
      } 
    }
    // update for next move or draw
    lastPoint = point;    
  }

  public void onMouseRelease(Location point) {
    // Add code when have collection of scribbles
	 if(chosenAction==DRAWING) {
		 scribbles = new NonEmptyScribbleCollection(currentScribble,scribbles);
	 }
  }

  /*
   * Set mode according to JButton pressed.
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == setDraw) {
      chosenAction = DRAWING;
      modeLabel.setText("Current mode: drawing");
    } else if (e.getSource() == setMove) {
      chosenAction = MOVING;
      modeLabel.setText("Current mode: moving");
    }
   //added to include color
    else if (e.getSource() == setColor) {
        chosenAction = COLORING;
        modeLabel.setText("Current mode: coloring");
    }
    else if(e.getSource()==setErase) {
    	ScribbleInterface s = scribbles.erase();
    	if(s != null) {
    		erasedScribbles = new NonEmptyScribbleCollection(s, erasedScribbles);
    	}
    } else if (e.getSource()==setUndo) {
    	//return scribble back to scribble collection
    	ScribbleInterface s = erasedScribbles.undo();
    	if(s != null) {
    		scribbles = new NonEmptyScribbleCollection(s, scribbles);
    	}
    }
  }
  

  public static void main(String args[]) {
	  new Scribbler().startController(500, 500);
	}
}
