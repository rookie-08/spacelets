package spacelets;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains a star, a protoplanetary disc, and planets.
 * 
 * @author Rookie
 */
public class StarSystem {
	/**
	 * The number of disc sections to have when creating this system.
	 */
	private static final int DISC_LENGTH = 10;

	/**
	 * The total mass of the disc when creating this system.
	 */
	private static final double DISC_MASS = 100.0;

	/**
	 * The mass of the star when creating this system.
	 */
	private static final double STAR_MASS = 300000.0;

	/**
	 * The protoplanetary disc and its sections' masses.
	 */
	private final double[] disc;

	/**
	 * The planets orbiting this system's star.
	 */
	private final List<Planet> planets;

	/**
	 * The star at the center of this system.
	 */
	private final Planet star; // TODO: Remove?

	/**
	 * Create a new system with a star and protoplanetary disc, but
	 * no planets (yet).
	 */
	public StarSystem() {
		// Create disc
		disc = new double[DISC_LENGTH];
		double massPerDiscSection = DISC_MASS / DISC_LENGTH;
		for (int i = 0; i < DISC_LENGTH; i++) {
			disc[i] = massPerDiscSection;
		}
		// Create planets and star
		planets = new ArrayList<>();
		star = new Planet(STAR_MASS);
	}

	// TODO: remove spawnPlanet() from UML

	// TODO: remove growPlanet() from UML

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
