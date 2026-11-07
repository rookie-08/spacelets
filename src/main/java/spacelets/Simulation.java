package spacelets;

import java.util.Random;

/**
 * Runs a simulation of a star system.
 * 
 * Also serves as the primary main class.
 * 
 * @author Rookie
 */
public class Simulation { // TODO: Rename to "Spacelets"
	/**
	 * The actual model star system of the class.
	 */
	private StarSystem system;

	/**
	 * The age of the simulation in ticks.
	 */
	int age;

	/**
	 * A random number generator that can start with a seed.
	 */
	Random random;

	/**
	 * Create a brand new simulation.
	 */
	public Simulation() {
		system = new StarSystem();
		age = 0;
		random = new Random(); // TODO: Configure seed
	}

	/**
	 * Increment time by a bit and make tiny changes to the
	 *  simulation and system.
	 */
	public void update() {
		age++;
		system.update();
	}

	/**
	 * Run the program by making a new simulation
	 * and updating it once.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting simulation.");
		Simulation simulation = new Simulation();
		simulation.update();
		System.out.println("End of program");
	}

}
