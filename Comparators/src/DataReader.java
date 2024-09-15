import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class DataReader {
	
	private static myVector<College> colleges;
	
	public static void main( String[] args){
		colleges = new myVector<College>();
		File myObj = new File(args [0]);
	    Scanner myReader;
		try {
			myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  String text = (myReader.nextLine());
		    	  	if (text.equals("")) {
		    		  break;
		    	  	}else {
		    	  String[] college = text.split(",",4);	
		    	   
		    	  colleges.add(new College(college[0],
		    			  Double.parseDouble(college[1]),
		    			  Double.parseDouble(college[2])));
	}
		      }		
		System.out.println("Original Data: ");
		for(College c: colleges) {
			System.out.println(c);
			System.out.println("");
		}
		
		System.out.println("Sort by Name (alphebetical): ");
		sort(new SortbyName());
		for(College c: colleges) {
			System.out.println(c);
			System.out.println("");
			}
		
		System.out.println("Sort by Population (increasing): ");
		sort(new SortbyPopulation());
		for(College c: colleges) {
			System.out.println(c);
			System.out.println("");
			}
		
		System.out.println("Sort by Acceptance Rate (decreasing): ");
		sort(new SortbyAcceptanceRate());
		for(College c: colleges) {
			System.out.println(c);
			System.out.println("");
			}
		
		}
		catch (FileNotFoundException e) {
		e.printStackTrace();
		System.exit(1);
	}
	}      
		      
		      
	public static void sort(Comparator<College> c) {
		 mergeSort(0, colleges.size()-1, c);
	}
	
	public static void mergeSort(int start, int end, Comparator<College> c) {
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(start, mid, c);
			mergeSort(mid + 1, end, c);
			merge(start, mid, end, c);
		}	
	}
	
	public static void merge(int start, int mid, int end, Comparator<College> c) {
		//Look at the vector in halves
		int start2 = mid + 1;
		
		if(c.compare(colleges.get(mid), colleges.get(start2)) <=0) {
			return;
		}
		while(start <= mid && start2 <= end) {
			if(c.compare(colleges.get(start), colleges.get(start2)) <= 0) {
				start++;
			} else {
				College temp = colleges.get(start2);
				int ind = start2;
				
				while(ind != start) {
					colleges.set(ind, colleges.get(ind-1));
					ind--;
				}
				colleges.set(start,  temp);
				start++;
				mid++;
				start2++;
			}
		}
	}
	
}

