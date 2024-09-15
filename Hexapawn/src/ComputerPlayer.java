
public class ComputerPlayer implements Player{

	private char player;
	
	public ComputerPlayer(char m) {
		this.player = m;
	}
	
	public char getSymbol() {
		return player;
	}

	public Player play(GameTree node, Player opponent) {
		System.out.println(node.getBoard());
		//check for loss
		if (node.getBoard().win(opponent.getSymbol()) ||
	            node.getChildren().isEmpty()) {
			System.out.println("");
			node.removeNode();
			return opponent;
		}
		
		int randMove = (int) (Math.random()* node.getChildren().size());
		
		return opponent.play(node.getChildAt(randMove), this);
	}


	public boolean isComp() {
		return true;
	}

}
