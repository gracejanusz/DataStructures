import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The individual creatures in the world are all representatives of some
 * species class and share certain common characteristics, such as the species
 * name and the program they execute. Rather than copy this information into
 * each creature, this data is recorded once as part of the description for
 * a species and then each creature can simply include the appropriate species
 * pointer as part of its internal data structure.
 * <p>
 * 
 * To encapsulate all of the operations operating on a species within this
 * abstraction, this provides a constructor that will read a file containing
 * the name of the creature and its program, as described in the earlier part
 * of this assignment. To make the folder structure more manageable, the
 * species files for each creature are stored in a subfolder named Creatures.
 * Thus, creating the Species for the file Hop.txt will causes the program to
 * read in "Creatures/Hop.txt".
 * 
 * <p>
 * 
 * Note: The instruction addresses start at one, not zero.
 */

public class Species {
	private String name;
	private String color;
	private ArrayList<Instruction> instructions;

	/**
	 * Create a species for the given file. 
	 * @param fileName the name of the file containing the data for the species
	 * @throws FileNotFoundException 
	 * @pre fileName exists in the Creature subdirectory.
	 */
 public Species(String fileName){
	    instructions = new ArrayList<Instruction>();
		//try catch here
		File myObj = new File(fileName);
	    Scanner myReader;
	    int address = 0;
	    int opcode = 0;
		try {
			myReader = new Scanner(myObj);
		    name = myReader.nextLine();
		    color = myReader.nextLine();
		      while (myReader.hasNextLine()) {
		    	  String text = (myReader.nextLine());
		    	  	if (text.equals("")) {
		    		  break;
		    	  	}else {
		    	  String[] inst = text.split(" ");
		    	  if(inst.length ==2){
		    	  address= Integer.parseInt(inst[1]);
		    	  }
		    	  switch (inst[0]) {
		    	  case "hop": opcode =Instruction.HOP;
		    	  		break;
		    	  case "left": opcode =Instruction.LEFT;
  	  					break;
		    	  case "right": opcode =Instruction.RIGHT;
  	  			        break;
		    	  case "infect": opcode =Instruction.INFECT;
  	  			        break;
		    	  case "ifempty": opcode =Instruction.IFEMPTY;
  	  					break;
		    	  case "ifwall": opcode =Instruction.IFWALL;
  	  					break;
		    	  case "ifsame": opcode =Instruction.IFSAME;
  	  					break;
		    	  case "ifenemy": opcode =Instruction.IFENEMY;
  	  					break;
		    	  case "ifrandom": opcode =Instruction.IFRANDOM;
  	  					break;
		    	  case "go": opcode =Instruction.GO;
  	  					break;
		    	  case "iftwoenemy": opcode =Instruction.IFTWOENEMY;
  	  					break;
		    	  case "ifeq": opcode =Instruction.IFEQ;
  	  					break;
		    	  case "inc": opcode =Instruction.INC;
  	  					break;
		    	  case "dec": opcode =Instruction.DEC;
  	  					break;
		    	  case "set": opcode =Instruction.SET;
  	  					break;
  	  			  default:
  	  				  System.out.println("Instruction not found!");
  	  				  System.exit(1);
		    	  }
		    	  instructions.add(new Instruction(opcode,address));
		      } 
		      } myReader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
}
	

	/**
	 * Return the name of the species.
	 */
	public String getName() {
	return name;
	}
	/**
	 * Return the color of the species.
	 */
	public String getColor() {
	return color;
	}

	/**
	 * Return the number of instructions in the program.
	 */
	public int programSize() {
	return instructions.size();
	}

	/**
	 * Return an instruction from the program. 
	 * @pre 1 <= i <= programSize().
	 * @post returns instruction i of the program.
	 */
	public Instruction programStep(int i) {
	return instructions.get(i-1);
	}

	/**
	 * Return a String representation of the program.
	 */
	public String programToString() {
	String s = "";
		for(int i =0; i<instructions.size();i++) {
		s += (instructions.get(i)).toString() + "\n";
	}
		return s;
	}
	
	public static void main(String args[]) {
		Species flytrap = new Species("Flytrap.txt");
		System.out.println(flytrap.getColor());
		System.out.println(flytrap.getName());
		System.out.println(flytrap.programSize());
		System.out.println(flytrap.programStep(1));
		System.out.println(flytrap.programToString());
		
	
	}
}


