import java.util.ArrayList;

import structure5.AbstractIterator;

public class SubsetIterator extends AbstractIterator<ArrayList<Integer>>{
 
	private long counter;
 private int num;
 private ArrayList<Integer> blocks;
 
 public  SubsetIterator(ArrayList<Integer> blocks) {
	 //construct the iterator
	 this.blocks = blocks;
	 num = blocks.size();
 }
 
 //returns if there is another block
 public boolean hasNext(){
	 return counter + 1 <= Math.pow(2, num);
 }
 
 public ArrayList<Integer> next() {
	 ArrayList<Integer> temp = (ArrayList<Integer>) get();
		counter++;
		return temp;
 }
	 
	 
	 
public ArrayList<Integer> get() {
	ArrayList<Integer> result = new ArrayList<Integer>();
	for(int i = 0; i < num; i++) {
		if((counter & (2 << i)) > 0) {
			result.add(blocks.get(i));
		}
	}
	return result;
}

 
 
 //resets counter to 0
 public void reset() {
	 counter = 0;
 }
 
 //returns counter
 public long getCounter() {
	 return counter;
 }
 
}
