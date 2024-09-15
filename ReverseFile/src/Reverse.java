/* 3.4: This may be useful when you want to have a certain amount of things
 * in the vector, but you don't have specific values of which you would like 
 * to add. This method adds null values into the vector if the new size is greater
 * than the size of the vector. If you want to pare down your vector, putting in a smaller
 * number into the method will discard all numbers at index size and greater.
 * while you can set the intiial capacity when you create the new
 * vector,  this doesn't insert any components to the vector leaving the vector
 * ultimately empty.
 * 3.6: In class BitVector class
 * 3.8: lets say that the size of the vector is n. to be able to get to n+1 we must
 * copy over a max of n objects. in the case where k is a constant.
 * # of copies = k + 2k+ 3k+ ... +N = k(1+2+3+...n/k)
 * when factoring out, we find that it equates to O(N^2)
 * where o(n) describes how many steps an algorithm takes based on the number of elements
 * that it is acted upon. this means that O(n^2) grows exponentially.
 */



import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
	import java.io.FileNotFoundException;
public class Reverse {

	    public static void main(String[] args) {
	    	Scanner fileReader = new Scanner(System.in);
	    	
	    	if (args.length>0) { 			    	
	        try {
	            //make new file which will be read, and new scanner
	        	File f = new File(args[0]);
	            fileReader = new Scanner(f);
	          
	            
	        }    
	        catch(FileNotFoundException f){
	            System.out.println("The file " + args[0] + " doesn't exist");
	            System.exit(0);
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	            System.out.println("Something else went wrong");
	            System.exit(0);
	        }
	    	
	        	
	    }
	    ArrayList<String> words = new ArrayList<String>();
       while(fileReader.hasNextLine()) {
    	   words.add(fileReader.nextLine());
       }
        //print out fil
        for(int i = words.size()-1; i>=0; i--) {
        	String[] strWords = words.get(i).split(" ");
        	System.out.println();
        	for(int j = strWords.length -1; j>= 0; j--) {
				System.out.print(strWords[j]+" ");
				}
        	}
        } 	
}
