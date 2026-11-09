package spacelets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
	 * A set of unique names.
	 */
	private final Set<String> planetNames;

	/**
	 * Random number generator for methods.
	 */
	private final Random random;

	/**
	 * Create a new system with a star and protoplanetary disk, but
	 * no planets (yet).
	 */
	public StarSystem(Random random) {
		disk = new Disk(random);
		planets = new HashMap<>();
		planetNames = new HashSet<>();
		this.random = random;
	}

	private String generateNameRaw() {
		return String.valueOf(random.nextInt(1000, 10000));
	}

	private String generateName() {
		String name = generateNameRaw();
		while (planetNames.contains(name)) {
			name = generateNameRaw();
		}
		planetNames.add(name);
		return name;
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
		String name = generateName();
		Planet planet = new Planet(name, mass, distance, random);
		planets.put(name, planet);
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
		return "StarSystem [Planets(" + planets.size() + ")]";
	}

}
