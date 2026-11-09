package spacelets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Contains a star, a protoplanetary disk, and planets.
 * 
 * @author Rookie
 */
public class StarSystem {
	/**
	 * The number of disk sections to have when creating this system.
	 */
	private static final int DISK_NUM_SECTIONS = 10;

	/**
	 * The distance of the last disk section to the star, in <unit>s.
	 */
	private static final double DISK_LENGTH = 10.0;

	/**
	 * The total mass of the disk when creating this system.
	 */
	private static final double DISK_MASS = 100.0;

	/**
	 * The protoplanetary disk and its sections' masses.
	 */
	private final double[] disk;

	/**
	 * The planets orbiting this system's star.
	 */
	private final List<Planet> planets;

	/**
	 * Create a new system with a star and protoplanetary disk, but
	 * no planets (yet).
	 */
	public StarSystem() {
		// Create disk
		disk = new double[DISK_NUM_SECTIONS];
		double massPerDiskSection = DISK_MASS / DISK_NUM_SECTIONS;
		for (int i = 0; i < DISK_NUM_SECTIONS; i++) {
			disk[i] = massPerDiskSection;
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
		int section = (int)(position / DISK_LENGTH * DISK_NUM_SECTIONS);
		if (section < 0) {
			section = 0;
		}
		if (section >= DISK_NUM_SECTIONS) {
			section = DISK_NUM_SECTIONS - 1;
		}

		// Remove mass from section
		double massTaken = disk[section] * frac;
		disk[section] = disk[section] - massTaken;

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
		double distance0 = (DISK_LENGTH * section / DISK_NUM_SECTIONS);
		double distance1 = (DISK_LENGTH * (section + 1) / DISK_NUM_SECTIONS);
		double distance = random.nextDouble(distance0, distance1);

		double mass = loseMass(distance, 0.1);
		Planet planet = new Planet(mass, distance);
		planets.add(planet);
	}

	/**
	 * Rolls multiple chances. Across all sections of disk. For each
	 * time a chance is successful in this method, a planet will be
	 * summoned.
	 * 
	 * @param random Random number generator.
	 */
	private void trySummon(Random random) {
		for (int i = 0; i < DISK_NUM_SECTIONS; i++) {
			double sectionMass = disk[i];
			if (random.nextDouble() < 0.01 * sectionMass) {
				summon(random, i);
			} 
		}
	}

	/**
	 * Makes each planet collect matter from the protoplanetary disk.
	 * 
	 * @param random Random number generator.
	 */
	private void feedPlanets(Random random) {
		for (int i = 0; i < planets.size(); i++) {
			Planet planet = planets.get(i);
			double loc = planet.chooseFeedLoc(random);
			double massTaken = loseMass(loc, 0.05);
			planet.gainMass(massTaken);
		}
	}

	/**
	 * Makes changes to the system.
	 */
	public void update(Random random) {
		trySummon(random);
		feedPlanets(random);
	}

	/**
	 * Returns a String representing the system and the number of
	 * planets it has.
	 */
	@Override 
	public String toString() {
		return "StarSystem [Planets(" + planets.size() + ")]";
	}

}
