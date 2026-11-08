package spacelets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Contains a star, a protoplanetary disc, and planets.
 * 
 * @author Rookie
 */
public class StarSystem {
	/**
	 * The number of disc sections to have when creating this system.
	 */
	private static final int DISC_NUM_SECTIONS = 10;

	/**
	 * The distance of the last disc section to the star, in <unit>s.
	 */
	private static final double DISC_LENGTH = 10.0;

	/**
	 * The total mass of the disc when creating this system.
	 */
	private static final double DISC_MASS = 100.0;

	/**
	 * The protoplanetary disc and its sections' masses.
	 */
	private final double[] disc;

	/**
	 * The planets orbiting this system's star.
	 */
	private final List<Planet> planets;

	/**
	 * Create a new system with a star and protoplanetary disc, but
	 * no planets (yet).
	 */
	public StarSystem() {
		// Create disc
		disc = new double[DISC_NUM_SECTIONS];
		double massPerDiscSection = DISC_MASS / DISC_NUM_SECTIONS;
		for (int i = 0; i < DISC_NUM_SECTIONS; i++) {
			disc[i] = massPerDiscSection;
		}
		// Create planets and star
		planets = new ArrayList<>();
	}

	/**
	 * Take mass from a section of the protoplanetary disk.
	 * 
	 * Even though `position` is a double and not an int, the
	 * parameter will be translated to the closest section of
	 * disk debris to take.
	 * 
	 * @param position The distance of the section to the star.
	 * @param frac The fraction of matter, from the section of the
	 * disk, to take. 
	 * @return The amount of mass taken from the disk section.
	 */
	private double loseMass(double position, double frac) {
		// Calculate section number
		int section = (int)(position / DISC_LENGTH * DISC_NUM_SECTIONS);

		// Remove mass from section
		double massTaken = disc[section] * frac;
		disc[section] = disc[section] - massTaken;

		return massTaken;
	}
	
	/**
	 * Summons a planet in a given section of disk.
	 * 
	 * The planet will be placed randomly in the disk section.
	 * 
	 * @param random Random number generator.
	 * @param section The ID of the disk section to place the planet.
	 */
	private void summon(Random random, int section) {
		// ...
	}

	/**
	 * Rolls multiple chances. Across all sections of disk. For each
	 * time a chance is successful in this method, a planet will be
	 * summoned.
	 * 
	 * @param random Random number generator.
	 */
	private void trySummon(Random random) {
		// ...
	}

	/**
	 * Makes each planet collect matter from the protoplanetary disk.
	 * 
	 * @param random Random number generator.
	 */
	private void feedPlanets(Random random) {
		// ...
	}

	/**
	 * Makes changes to the system.
	 */
	public void update() {

	}

	/**
	 * Returns a String representing the system and the number of
	 * planets it has.
	 */
	@Override 
	public String toString() {
		return "System [Planets(" + planets.size() + ")]";
	}

}
