
/**
 * This class represents one creature on the board.
 * Each creature remembers its species, position, direction,
 * and the world in which it is living.
 * <p>
 * In addition, the Creature remembers the next instruction
 * out of its program to execute.
 * <p>
 * The creature is also repsonsible for making itself appear in
 * the WorldMap.  In fact, you should only update the WorldMap from
 * inside the Creature class. 
 */

public class Creature {
	private Species species;
	private World<Creature> world;
	private Position pos;
	private int dir;
    int step;
    /**
     * Create a creature of the given species, with the indicated
     * position and direction.  Note that we also pass in the
     * world-- remember this world, so that you can check what
     * is in front of the creature and to update the board
     * when the creature moves.
	 * @param species The species of the creature
	 * @param world The world in which the creature lives
	 * @param pos The position of the creature
	 * @param dir The direction the creature is facing
	 * @pre species, world, and pos must be non-null
	 * @pre pos must be within the bounds of world
	 * @pre dir must be one of: Position.NORTH, Position.SOUTH, Position.EAST
	 *                          or Positon.WEST
	 * @pre the world map must have been created
	 * @post creates a creature of species species in world world at position
	 *       pos facing direction dir
	 * @post initializes instance variables so that the creature knows what
	 *		 instruction to begin executing
	 * @post displays the creature on the world map
     */
    public Creature(Species species, World<Creature> world, Position pos, int dir) {
	this.species = species;
	this.pos = pos;
	this.dir = dir;
	this.world = world;
	world.set(pos, this);
	step=1;
	WorldMap.displaySquare(pos, species.getName().charAt(0), dir, species.getColor());
    }

    /**
     * Return the species of the creature.
     */
    public Species species() {
	return species;
    }

    /**
     * Return the current direction of the creature.
    */
    public int direction() {
    return dir;
    }

    /**
     * Return the position of the creature.
     */
    public Position position() {
    return pos;
    }

    /**
     * Execute steps from the Creature's program until 
     * a hop, left, right, or infect instruction is executed.
	 * @post Creature takes one turn's worth of instructions
	 * @post display is updated to reflect movement of this creature
	 *
     */
    public void takeOneTurn() {
    //long start = System.currentTimeMillis();
	Creature target;
    boolean running = true;
	while (step<= species.programSize() && running) {
//		if(System.currentTimeMillis()-start > 10) {
//			System.out.println("running for a long time");
//		}
		Instruction currentStep = species.programStep(step);
		switch (currentStep.getOpcode()) {
    	//hop
    	case Instruction.HOP:{
    		if(world.inRange(pos.getAdjacent(dir)) && world.get(pos.getAdjacent(dir))==(null)) {
    		WorldMap.displaySquare(pos,' ', dir, species.getColor());
    		world.set(pos, null);
    		pos = pos.getAdjacent(dir);
    		world.set(pos, this);
    		WorldMap.displaySquare(pos, species.getName().charAt(0), dir, species.getColor());
    		}
    		running = false;
    	} break;
    	//left
    	case Instruction.LEFT: {
        	dir = (dir+3)%4;
    		WorldMap.displaySquare(pos, species.getName().charAt(0), dir, species.getColor());
        	running = false;	
    	} break;
		//right	
    	case Instruction.RIGHT: {
        		dir = (dir+1)%4;
    			WorldMap.displaySquare(pos, species.getName().charAt(0), dir, species.getColor());
    		running = false;
    	}break;
	   
    	//infect COMPLETE!!
    	case Instruction.INFECT:{
    		if(world.inRange(pos.getAdjacent(dir))&& world.get(pos.getAdjacent(dir))!=null) {
    		target = world.get(pos.getAdjacent(dir));
    		if (target.species()!= this.species()) {
    		target.species = this.species;
    		target.step= currentStep.getAddress();
    		world.set(pos, target);
    		WorldMap.displaySquare(pos.getAdjacent(dir), this.species().getName().charAt(0), target.direction(), this.species().getColor());
    		}
    		}
    		running = false;
    		}break;
    	
    	//if empty
    	case Instruction.IFEMPTY:{
    		if(world.inRange(pos.getAdjacent(dir)) && world.get(pos.getAdjacent(dir))==(null)) {
    		 step = currentStep.getAddress()-1;
    		}
    	} break;
    	
    	//if wall
    	case Instruction.IFWALL: {
    		if(!world.inRange(pos.getAdjacent(dir)))
    		step = currentStep.getAddress()-1;
    	} break;
    	
    	//ifsame
    	case Instruction.IFSAME:{
    		if(world.inRange(pos.getAdjacent(dir)) && world.get(pos.getAdjacent(dir))!=(null)) {
    		target = world.get(pos.getAdjacent(dir));
    		if (target.species == this.species) {
    		step = currentStep.getAddress()-1;
    		}
    		}
    	}break;
    	
    	//if enemy
    	case Instruction.IFENEMY:{
    		if(world.inRange(pos.getAdjacent(dir)) && world.get(pos.getAdjacent(dir))!=(null)) {
        		target = world.get(pos.getAdjacent(dir));
        		if (target.species != this.species) {
        		step = currentStep.getAddress()-1;
    	}
    	}
    	}break;
    	//if random
    	case Instruction.IFRANDOM:{
    		if(Math.random()>0.5) {
    		step = (int)(Math.random()*species.programSize());
    		}
    	}break;
    	//go
    	case Instruction.GO:{
    			step = currentStep.getAddress()-1;
    		}break;
    	}
		 step++;
	}	
//		 } System.out.println(System.currentTimeMillis()-start);
    }
    	
    public static void main(String args[]) {
    World<Creature> w = new World<Creature>(15,15);
    WorldMap.createWorldMap(15, 15);
    Position p = new Position(14,0);
//    Position c = new Position(7,0);
    Species s = new Species("Rover.txt");
//    Species f = new Species("Flytrap.txt");
    Creature rover = new Creature(s,w, p ,1);
//    Creature flytrap = new Creature(f,w, c ,1);
    for(int i=0; i<100;i++) {
    WorldMap.pause(500);
    rover.takeOneTurn();
//    flytrap.takeOneTurn();
    
    }
    }
}
