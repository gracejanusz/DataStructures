import structure.*;
import java.util.Iterator;
import java.util.Scanner;

public class HumanPlayer implements Player{

	private char player;

	public HumanPlayer(char m) {
		this.player = m;
	}
	
	public char getSymbol() {
		return player;
	}
	
	
	
	
	public Player play(GameTree node, Player opponent) {
		Scanner sc = new Scanner(System.in);
		//prints out what the board looks like 
		System.out.println(node.getBoard());
		
		if (node.getBoard().win(opponent.getSymbol()) ||
	            node.getChildren().isEmpty()) {
			//if there are no more move possible moves then 
			//the player has reached a leaf indicating they have lost
		    return opponent;
		}
	            
			Vector moves = node.getBoard().moves(player);
	            for(int i = 0; i<moves.size();i++) {
	                System.out.println(i + ". " + moves.get(i).toString());      
	            }

	                int yourMove = Integer.parseInt(sc.nextLine());
	                while(yourMove >= moves.size()) {
	                	System.out.println("Invalid Move: Try again");
	                	yourMove = Integer.parseInt(sc.nextLine());
	                }
	                return opponent.play(node.getChildAt(yourMove), this);	      	            		

	}
	
	public boolean isComp() {
		return false;
	}
//	public static void main(String [] args) {
//		//instantiate two human players, board.
//		Player p1 = new HumanPlayer(HexBoard.WHITE);
//		Player p2 = new HumanPlayer(HexBoard.BLACK);
//		HexBoard h = new HexBoard();
//		p1.play(new GameTree(h, HexBoard.WHITE), p2);
//		
//			
//	}
}
