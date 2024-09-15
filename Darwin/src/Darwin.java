import java.util.ArrayList;
import java.util.Collections;
/**
* This class controls the simulation. The design is entirely up to
* you. You should include a main method that takes the array of
* species file names passed in and populates a world with species of 
* each type.
* <p>
* Be sure to call WorldMap.pause every time
* through the main simulation loop or else the simulation will be too fast
* and keyboard / mouse input will be slow. For example: 
* <pre>
*	public void simulate() {
*	for (int rounds = 0; rounds < numRounds; rounds++) {
*           giveEachCreatureOneTurn();
*           WorldMap.pause(100);
*         }
*	}
* </pre>
*/

/*THOUGHT QUESTIONS
 * 1. In order to make a program to count whether rovers or flytraps win more,
 * you would need to create a counter that counts how many of each species are left, 
 * and a boolean that will run instead of the while (true) loop at the bottom of the Darwin main method. In addition
 * I would enclose the entire main method into a while true method, so after one prohram ends another one
 * subsequently starts. 
 * When the boolean, lets say titled "Extinct", gets set to false, by a counter reaching zero (and effectively
 * a species going extinct) the loop will end, and the creatures will stop taking turns. After the while loop,
 * I would add an if statement that will increment either Rover wins or Flytrap wins, effectively being the 
 * counter of the two. Following the if statements the code will reach the end of the initial while loop, therefore 
 * restarting the program. There is also a case in which an infinite loop occurs and both creature amounts never go extinct.
 * In that case, I would most likely have a checker for the counter of all creatures that will restart the program 
 * and declare it a tie, if the counters stay the same for multiple (I mean like 50) turns in a row. Although I cannot be certain
 * that this code is sufficient, this is most likely how I would approach this code.
 * 
 * 2. JIT is a compilier that performs optimizations in order to bring down the run time associated with the Java Virtual Machine,
 * the thing that allows us to run java programs, and compile bytecode into native machine code. The JIT allows for a faster run time, except in
 * certain cases, like when a single method is run over and over again, while the the JVM would take much longer and will repeatedly
 * interpret bytecode overhead. Optimizations by JIT to cut down time include: reduction of memory access through register allocation 
 * (using less memory by assigning certain information to memory space in order to be able to recognise patterns), elimination of
 * common sub-expressions, and etc.
 * 
 * 3. Personally I do agree with him, because while I do think that it is functional, there is far too much space for
 * potential human error. For instance, in the Darwin program, you must somehow (well not somehow, because I
 * did achieve it in my code but for my writing's sake, I'll keep it) eliminate 2 lines read in from the text file 
 * to account for the instruction line. After that, the txt file uses 1 as a starting point, which contrasts to 
 * the 0 that is the standard java index.
 * Accounting for all of these numbers, and remembering which index is for which thing, is easy for the computer to do,
 * but also could be damaging for the code. Let's say we were to change the index of the txt files back to 0, then I would have
 * to go back into the code manually and change all of my constants that follow the .getAddress() method, otherwise my code would 
 * be ineffective.
 * Perhaps I am not one to complain much though, because I cannot come up with a replacement off the top of my head, so for now
 * I will just use, and struggle, with the 'go to' statements that lie ahead.
 */



class Darwin {

	/**
	* The array passed into main will include the arguments that 
	* appeared on the command line. For example, running "java 
	* Darwin Hop.txt Rover.txt" will call the main method with s 
	* being an array of two strings: "Hop.txt" and "Rover.txt". 
	*/
	public static void main(String s[]) {
		World<Creature> world = new World<Creature>(15, 15);
		WorldMap.createWorldMap(15, 15);
		ArrayList<Creature> creatures = new ArrayList<Creature>();
		for(String sp:s) {
			Species spec = new Species(sp);
			int numCreatures=0;
			while(numCreatures <11) {
		Position p = new Position(((int)(Math.random()*14)), (int)(Math.random()*14));
		int dir = (int)(Math.random()*4);
		Creature c = new Creature(spec,world,p,dir);
		creatures.add(c);
		world.set(p, c);
		numCreatures++;
			}
		}	
	while(true) {
		//shuffle list so no inherant advantage
		Collections.shuffle(creatures);
    	for(Creature creature : creatures) {
    		creature.takeOneTurn();
    		WorldMap.pause(5);
    	}
    	}
	}
}
