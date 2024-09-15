
public class RandomPlayer implements Player {

	char player;
	
	
	public RandomPlayer(char m) {
		this.player = m;
	}

	
	public char getSymbol() {
		return player;
	}
	

	//plays with RandomPlayer
	public Player play(GameTree node, Player opponent) {
		System.out.println(node.getBoard());
		//check for loss
		if (node.getBoard().win(opponent.getSymbol()) ||
	            node.getChildren().isEmpty()) {
			return opponent;
		}
		int randMove = (int) (Math.random()* node.getChildren().size());
		
		return opponent.play(node.getChildAt(randMove), this);
	}

	public boolean isComp() {
		return true;
	}
	
}
