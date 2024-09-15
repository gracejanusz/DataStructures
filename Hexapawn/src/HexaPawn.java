import java.util.Scanner;

/*1. There are 6003 board positions for a 3x4 board and 215150 board positions for a 3x5 board.
 * 
 * 2. HIM will win more often after about 10-20 play throughs of the program
 * because HIM will remove all of his losing moves, making it more optimal for him. 
 * On a larger board, it will take 
 * more games for either computer to become unstoppable due to the large gametree that results from 
 * a larger board. Ultimately all the different board variations lead to different win situations. 
 * 3x4 leads to HER winning more often, while larger boards tend to be more equal in their win 
 * distribution.
 * 
 * 
 * 3. The reflection of a gameboard is just the same moves but reflected onto the other side. 
 * Cutting half the children off the gametree for redundancy and keeping track of if a gametree
 * is mirrored, will hypothetically save more space.
 *   
 *   o o       and       o o
 *       o             o
 *   x x x             x x x
 *   
 *   Those boards ultimately have the same gametrees but just flipped. You would need to create a 
 *   boolean variable that tracks whether the tree is mirrored.If mirrored is true, the right subtrees
 *   would reference the left subtrees. There would need to be methods in both HexMove and HexBoard that 
 *   prints the moves out reflected and the boards out reflected, respectively.
 */







public class HexaPawn {

	private static Player p1;
	private static Player p2;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Player Types: Human (h), Random (r), Computer (c)");
		System.out.println("White goes first. Black goes second.");
		
		System.out.println("Choose a player for WHITE: h, r, c");
		String white = sc.nextLine().strip().toLowerCase();
		while(!white.equals("h") && !white.equals("r") && !white.equals("c")) {
			System.out.println("Invalid Player Type: Try Again");
			white = sc.nextLine().strip().toLowerCase();
		}
		switch (white) {
		case "h":
			p1 = new HumanPlayer(HexBoard.WHITE);
			break;
		case "r":
			p1 = new RandomPlayer(HexBoard.WHITE);
			break;
		case "c":
			p1 = new RandomPlayer(HexBoard.WHITE);
			break;
		}
	
	System.out.println("Choose a player for BLACK: h, r, c");
	String black = sc.nextLine().strip().toLowerCase();
	while(!black.equals("h") && !black.equals("r") && !black.equals("c")) {
		System.out.println("Invalid Player Type: Try Again");
		black = sc.nextLine().strip().toLowerCase();
	}
	switch (black) {
	case "h":
		p2 = new HumanPlayer(HexBoard.BLACK);
		break;
	case "r":
		p2 = new RandomPlayer(HexBoard.BLACK);
		break;
	case "c":
		p2 = new RandomPlayer(HexBoard.BLACK);
		break;
	}
	
	
	
	
	GameTree g = new GameTree(new HexBoard(3,3), HexBoard.WHITE); 
	
	if((p1.isComp() && p2.isComp())) {
	int whiteWins = 0;
	int blackWins = 0;
	
	System.out.println("Number of Games: ");
	while(!sc.hasNextInt()) {
		
	}
	int numGames = sc.nextInt();
	
	for(int i = 0; i < numGames; i++) {
		
		char m =p1.play(g,p2).getSymbol();
		System.out.println(m + " wins!");
		if(m == HexBoard.WHITE) { 
			whiteWins++;
		}
		else blackWins++;
		}
	
	System.out.println("-----------------------");
	
	System.out.println("White wins: " + whiteWins);
	System.out.println("Black wins: " + blackWins);
	System.out.println("White % win: " + (double) whiteWins / (whiteWins + blackWins));
	System.out.println("Black % win: " + (double) blackWins / (whiteWins + blackWins));
	
	} else do {
          Player winner = p1.play(g, p2);
          System.out.println("(" + winner.getSymbol() + ") has won!" +
                       "\n Play Again? y/n");
    
        } while (sc.next().toLowerCase().equals("y"));
	}	
}
