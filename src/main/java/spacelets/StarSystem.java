package spacelets;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

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
	private final Map<String, Planet> planets;

	/**
	 * Random number generator for methods.
	 */
	private final Random random;

	/**
	 * Name generator.
	 */
	private final NameGenerator nameGenerator;

	/**
	 * Create a new system with a star and protoplanetary disk, but
	 * no planets (yet).
	 */
	public StarSystem(Random random, NameGenerator nameGenerator) {
		disk = new Disk(random);
		planets = new HashMap<>();
		this.random = random;
		this.nameGenerator = nameGenerator;
	}
	
	/**
	 * Summons a planet in a given section of disk.
	 * 
	 * The planet will be placed randomly in the disk section.
	 * 
	 * @param section The ID of the disk section to place the planet.
	 */
	private void summon(double mass, int section) {
		double distance = disk.choosePosition(section);
		String name = nameGenerator.next();
		if (name != null) {
			Planet planet = new Planet(name, mass, distance, random);
			planets.put(name, planet);
		}
	}

	/**
	 * Rolls multiple chances. Across all sections of disk. For each
	 * time a chance is successful in this method, a planet will be
	 * summoned.
	 */
	private void trySummon() {
		double[] summons = disk.takeSummons();
		for (int i = 0; i < summons.length; i++) {
			double summonMass = summons[i];
			if (summonMass > 0) {
				summon(summonMass, i);
			}
		}
	}

	/**
	 * Makes each planet collect matter from the protoplanetary disk.
	 */
	private void feedPlanets() {
		for (String planetName : planets.keySet()) {
			Planet planet = planets.get(planetName);
			double loc = planet.chooseFeedLoc();
			double massTaken = disk.takeMass(loc, 0.05);
			planet.gainMass(massTaken);
		}
	}

	/**
	 * Makes changes to the system.
	 */
	public void update() {
		trySummon();
		feedPlanets();
		disk.diffuse();
	}

	/**
	 * Returns a String representing the system and the number of
	 * planets it has.
	 */
	@Override 
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("StarSystem\n");
		builder.append(disk.toString() + "\n");
		builder.append("Planets (" + planets.size() + "):\n");
		for (String planetName : planets.keySet()) {
			Planet planet = planets.get(planetName);
			builder.append(planet.toString() + "\n");
		}

		return builder.toString();
	}

}
