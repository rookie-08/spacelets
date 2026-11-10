package spacelets;

import java.util.Random;
import java.util.Scanner;

/**
 * Runs a simulation of a star system.
 * 
 * Also serves as the primary main class.
 * 
 * @author Rookie
 */
public class Spacelets {
	/**
	 * The actual model star system of the class.
	 */
	private final StarSystem system;

	/**
	 * A random number generator that can start with a seed.
	 */
	private final Random random;

	/**
	 * A name generator.
	 */
	private final NameGenerator nameGenerator;

	/**
	 * Create a brand new simulation with a random seed.
	 */
	public Spacelets() {
		random = new Random();
		nameGenerator = new IntegerNameGenerator(random);
		system = new StarSystem(random, nameGenerator);
	}

	/**
	 * Create a brand new simulation with a desired seed.
	 */
	public Spacelets(long seed) {
		this();
		random.setSeed(seed);
	}

	/**
	 * Increment time by a bit and make tiny changes to the
	 *  simulation and system.
	 */
	public void update() {
		system.update();
	}

	public void updateMultiple(int times) {
		for (int i = 0; i < times; i++) {
			update();
		}
	}

	/**
	 * Run the program by making a new simulation
	 * and updating it once.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting simulation.");
		Spacelets simulation = new Spacelets();

		Scanner scanner = new Scanner(System.in);

		System.out.println(simulation.system);
		System.out.print("Press enter to continue with simulation ");
		String userInputString = scanner.nextLine();

		boolean sentinel = true;
		while (sentinel) {
			simulation.updateMultiple(1);
			System.out.println(simulation.system);
			System.out.print("Type 'END' to end simulation. Otherwise, press ENTER to continue ");
			userInputString = scanner.nextLine();
			if (userInputString.equals("END")) {
				sentinel = false;
			}
		}
		scanner.close();
		System.out.println("End of program");
	}

}
