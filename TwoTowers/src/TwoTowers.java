import java.util.ArrayList;


/*1.The best solution for 15 blocks is [4, 5, 6, 10, 11, 12, 13] with a height of 20.23411306140849 inches.
  This is 4.8523866281513506E-4 away from half of the total height.
 * 2. Implementing RandomSubset would require a Math.random that generates an int between 0 and 2^n-1 that determines
 * which subset we will evaluate.
 * Where going through each subset would take far too long for us computer scientists to wait, 
 * creating a method that will find the closest estimate for however long we are willing to wait would
 *  be most desirable. Therefore random subset is optimal.
 */

public class TwoTowers {
	
 private static int num =15;	
	
 public static void main(String args[]) {
	 ArrayList<Integer> blocks = new ArrayList<Integer>();
	 for(int i =0; i<=num; i++) {
		 blocks.add(i);
	 }
 double totalHeight = totalHeight(blocks);
 System.out.println("Total height of blocks is: " +totalHeight);
 double halfHeight = totalHeight/2;
 
    long counter;
 
    SubsetIterator i = new SubsetIterator(blocks);
	ArrayList<Integer> subsetBlocks = i.next();
 
	double max = totalHeight(subsetBlocks);
	ArrayList<Integer> bestBlocks = subsetBlocks;
	
	double secondHeighest = max;
	ArrayList<Integer> secondBestBlocks = subsetBlocks;
	
	
	while(i.hasNext()) {
		ArrayList<Integer> currentBlocks = i.next();
		double currentSubsetHeight = totalHeight(currentBlocks);
		
		
		if(currentSubsetHeight > secondHeighest && currentSubsetHeight < max) {
			secondHeighest = currentSubsetHeight;
			secondBestBlocks = currentBlocks;
		}
		
		if(currentSubsetHeight < halfHeight && currentSubsetHeight > max) {
			bestBlocks = currentBlocks;
			max = currentSubsetHeight;
			counter = i.getCounter();
		}
		
		
	}
	System.out.println("The best solution for " + num+ " blocks is " + bestBlocks + 
			" with a height of "+ max + " inches.");
	System.out.println("This is "+ (halfHeight - max) + " away from half of the total height.");
 }

private static double totalHeight(ArrayList<Integer> blocks) {
	double sum = 0;
	for(int i = 0; i< blocks.size(); i++) {
		sum += Math.sqrt((double)(blocks.get(i)));
	}
	return sum;
}
}

