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
	 * The protoplanetary disk and its sections' masses.
	 */
	private final Disk disk;

	/**
	 * The planets orbiting this system's star.
	 */
	private final List<Planet> planets;

	/**
	 * Random number generator for methods.
	 */
	private final Random random;

	/**
	 * Create a new system with a star and protoplanetary disk, but
	 * no planets (yet).
	 */
	public StarSystem(Random random) {
		disk = new Disk();
		planets = new ArrayList<>();
		this.random = random;
	}
	
	/**
	 * Summons a planet in a given section of disk.
	 * 
	 * The planet will be placed randomly in the disk section.
	 * 
	 * @param random Random number generator.
	 * @param section The ID of the disk section to place the planet.
	 */
	private void summon(double mass, int section) {
		double distance = disk.choosePosition(random, section);
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
	private void trySummon() {
		double[] summons = disk.takeSummons(random);
		for (int i = 0; i < summons.length; i++) {
			double summonMass = summons[i];
			if (summonMass > 0) {
				summon(summonMass, i);
			}
		}
	}

	/**
	 * Makes each planet collect matter from the protoplanetary disk.
	 * 
	 * @param random Random number generator.
	 */
	private void feedPlanets() {
		for (int i = 0; i < planets.size(); i++) {
			Planet planet = planets.get(i);
			double loc = planet.chooseFeedLoc(random);
			double massTaken = disk.loseMass(loc, 0.05);
			planet.gainMass(massTaken);
		}
	}

	/**
	 * Makes changes to the system.
	 */
	public void update() {
		trySummon();
		feedPlanets();
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
