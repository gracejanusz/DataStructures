import objectdraw.*;

public class NonEmptyScribbleCollection implements ScribbleCollectionInterface {

	private ScribbleInterface newScribble;
	private ScribbleCollectionInterface rest;
	
  public NonEmptyScribbleCollection(ScribbleInterface addedScribble,
                                    ScribbleCollectionInterface theRest) {
  newScribble = addedScribble;
  rest = theRest;
  }

  // pre:
  // post: returns the scribble that contains the point;
  //    if none contain it, returns an empty scribble
  public ScribbleInterface scribbleSelected(Location point) {
    //check for new
	  if(newScribble == null) {
		  return null;
	  }else if (!newScribble.isHidden() && newScribble.contains(point)) {
		  return newScribble;
	  }else {
		  return rest.scribbleSelected(point);
	  }
  }

  // pre:
  // post: returns the first scribble in the list;
  //   returns null if the list is empty.
  public ScribbleInterface getFirst() {
    return newScribble;   // change if necessary!
  }

  // pre:
  // post: returns the list of scribbles excluding the first.
  //   returns an empty scribble collection if the list is empty.
  public ScribbleCollectionInterface getRest() {
    return rest;   // change if necessary!
  }
  
  public ScribbleInterface erase() {
	  ScribbleInterface s = null;
	  if(newScribble != null) {
		  s = newScribble;
		  newScribble.erase();
		  newScribble = rest.getFirst();
		  rest = rest.getRest();
	  } 
	  return s;
  }
  
  public ScribbleInterface undo() {
	  ScribbleInterface s = null;
	//Only undo if there is something to undo
	  if(newScribble != null) {
		  // Undo most recently erased scribble
		  s = newScribble;
		  newScribble.undo();
		  // Set most recent scribble to first of rest
		  newScribble = rest.getFirst();
		  // Set rest to rest of rest (not including first)
		  rest = rest.getRest();
	  }
	  return s;
  }
  
}