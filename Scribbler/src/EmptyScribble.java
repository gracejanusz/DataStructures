

import objectdraw.*;

/*
 * Class representing an empty scribble.
 */
public class EmptyScribble implements ScribbleInterface {

	public EmptyScribble() {
  }

  // point is never in an empty scribble!
  public boolean contains(Location point) {
    return false;
  }

  // nothing to move, so do nothing!
  public void move(double xOffset, double yOffset) {
  }

public void setColor(String color) {	
}

public void undo() {
}

public boolean isHidden() {
	return true;
}

@Override
public void erase() {
	// TODO Auto-generated method stub
	
}
}