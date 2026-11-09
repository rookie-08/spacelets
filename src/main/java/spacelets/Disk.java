package spacelets;

import java.util.Random;

/**
 * A protoplanetary disk. It is divided into sections based on the
 * distance of each section to the star. Mass can be taken from the
 * disk, usually to grow planetary bodies.
 * 
 * @author Rookie
 */
public class Disk {
	/**
	 * The number of sections to split the Disk into.
	 */
	private static final int NUM_SECTIONS = 10;

	/**
	 * The boundary of the furthest section of the disk to the star.
	 */
	private static final double LENGTH = 10.0;

	/**
	 * The net mass of the disk to be spread out into sections.
	 */
	private static final double MASS = 100.0;

	/**
	 * An array of different sections of the disk, each with its own
	 * standalone amount of mass.
	 */
	private final double[] sections;

	/**
	 * Create a new disk with uniform density.
	 */
	public Disk() {
		sections = new double[NUM_SECTIONS];
		double massPerSection = MASS / NUM_SECTIONS;
		for (int i = 0; i < NUM_SECTIONS; i++) {
			sections[i] = massPerSection;
		}
	}

	@Override
	public String toString() {
		// Setup
		StringBuilder builder = new StringBuilder();
		double maxSectionMass = 0.0;
		double netMass = 0.0;

		// Get net and max mass
		for (double sectionMass : sections) {
			netMass += sectionMass;
			if (sectionMass > maxSectionMass) {
				maxSectionMass = sectionMass;
			}
		}

		// Build string
		builder.append("Disk [");
		builder.append(netMass);
		builder.append(", ");
		for (double sectionMass : sections) {
			// Get a number between 0 and 9
			double relativeSectionMass = sectionMass / maxSectionMass;
			String relativeSectionMassString = "9";
			if (relativeSectionMass < 1.0) {
				int desiredInteger = (int)(relativeSectionMass * 10);
				relativeSectionMassString = String.valueOf(desiredInteger);
			}
			if (relativeSectionMass <= 0.0) {
				relativeSectionMassString = "0";
			}
			builder.append(relativeSectionMassString);
		}
		builder.append("]");

		return builder.toString();
	}

	/**
	 * Take a fraction of matter away from a section of the disk.
	 * 
	 * @param section The section ID to take from.
	 * @param frac The fraction of matter to take from the section.
	 * @return The mass taken from the disk, in Earth masses.
	 */
	public double loseMass(int section, double frac) {
		double usedFrac = frac;
		if (usedFrac < 0.0) {
			usedFrac = 0.0;
		} else if (usedFrac > 1.0) {
			usedFrac = 1.0;
		}

		double massTaken = sections[section] * usedFrac;
		sections[section] -= massTaken;
		return massTaken;
	}

	/**
	 * Take a fraction of matter away from a section of the disk.
	 *
	 * Instead of taking matter from a specified section, this method
	 * will take matter from a section of the disk that contains the
	 * desired position to take matter from.
	 * 
	 * @param position The distance of the section to take, in AU.
	 * @param frac The fraction of matter to take from the disc section. 
	 * @return The mass taken from the disk, in Earth masses.
	 */
	public double loseMass(double position, double frac) {
		// Calculate section number
		int section = (int)(position / LENGTH * NUM_SECTIONS);
		
		// Edge cases (out of bounds)
		if (section < 0) {
			section = 0;
		}
		if (section >= NUM_SECTIONS) {
			section = NUM_SECTIONS - 1;
		}


		// Remove mass from section
		return loseMass(section, frac);
	}

	/**
	 * Get a randomly-generated distance value that sits within a
	 * `section` of the Disk.
	 */
	public double choosePosition(Random random, int section) {
		double distance0 = (LENGTH * section / NUM_SECTIONS);
		double distance1 = (LENGTH * (section + 1) / NUM_SECTIONS);
		double distance = random.nextDouble(distance0, distance1);
		return distance;
	}

	/**
	 * Randomly takes fractions of the disk's sections to be turned
	 * into planets.
	 * 
	 * @return An array of doubles representing the mass taken from
	 * each section of the disk during the operation.
	 */
	public double[] takeSummons(Random random) {
		double[] summons = new double[NUM_SECTIONS];
		for (int i = 0; i < NUM_SECTIONS; i++) {
			double sectionMass = sections[i];
			if (random.nextDouble() < 0.01 * sectionMass) {
				summons[i] = loseMass(i, 0.1);
			} 
		}
		return summons;
	}
}
