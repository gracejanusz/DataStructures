
import java.util.Random;

import structure.Vector;
import structure5.Queue;
import structure5.QueueVector;

public class GameTree {
	
	//parent variable
	private GameTree parent;
	
	//the starting board
	private HexBoard firstboard;
	
	//whose turn it is
	private char player;
	
	//a vector of all the possible moves following a move.
	private Vector possibleMoves;
	
	//a vector of GameTrees that are populated with other GameTrees.
	private Vector children;
	
	private static int size = 1;
	
	//for the root move, does not have a parent
	public GameTree(HexBoard firstboard, char m) {
		 this(null, firstboard, m);
	}
	
	// constructs GameTree
	public GameTree(GameTree parent, HexBoard firstboard, char m) {
	this.parent = parent;
	this.firstboard = firstboard;
	this.player = m;
	possibleMoves = firstboard.moves(player);	
	
	
	this.children = new Vector();
//	this.setChildren(firstboard, possibleMoves);
	if(firstboard.win(HexBoard.opponent(player))) return;
	
	for(int i = 0; i < possibleMoves.size(); i++) {
		children.add(new GameTree(this,
				new HexBoard(firstboard,(HexMove)possibleMoves.elementAt(i)), 
				HexBoard.opponent(player)));
		size++;
	}	
	}
	
	// sets the children of this vector to an array of other game trees
	// which all contain the possible moves
//	public void setChildren(HexBoard firstboard, Vector possibleMoves) {
//		
//		if(!possibleMoves.isEmpty()){
//			for(int i =0; i< possibleMoves.size();i++){
//				children.add(new GameTree(this,
//						   new HexBoard(this.firstboard, (HexMove)possibleMoves.get(i)),
//						   HexBoard.opponent(player)));
//			}
//		}
//	}
	
	//makes a move
	public GameTree makeAMove() {
		Random r = new Random();
		return (GameTree) children.get(r.nextInt(children.size()));
	    }
	
	
	//size
	public int size() {
		return size;
	}
	
	//returns child
	public Vector getChildren(){
		return children;
	}
	
	public GameTree getChildAt(int i) {
		return (GameTree) children.get(i);
	}
	//returns parent
	public GameTree getParent() {
		return parent;
	}
	//returns board
	public HexBoard getBoard() {
		return firstboard;
	}
	
	public void removeNode() {
		if (this.parent != null) this.parent.getParent().getChildren().remove(parent);
		}	
	
//	
//	public static void main(String [] args) {
//		GameTree gt = new GameTree(new HexBoard(3,3), '*');
//		System.out.println(gt.size());
//	}
}
