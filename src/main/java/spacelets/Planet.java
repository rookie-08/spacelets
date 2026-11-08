package spacelets;

import java.util.Random;

/**
 * A celestial body with a mass and distance to its parent body.
 * 
 * @author Rookie
 */
public class Planet {
	/**
	 * The mass of this planet, in <unit>s.
	 */
	private double mass;

	/**
	 * The distance of the planet to its star, in <unit>s.
	 */
	private double position;

	/**
	 * Create a planet with a set mass.
	 * 
	 * @param mass The mass to set this planet to, in <unit>s.
	 * @param position Where to place this planet. Distance from 
	 * star in <unit>s.
	 */
	public Planet(double mass, double posiiton) {
		this.mass = mass;
		this.position = posiiton;
	}

	/**
	 * Returns a String containing the planet's raw data.
	 */
	@Override 
	public String toString() {
		return "Planet [mass=" + mass + ", position=" + position + "]";
	}

	/**
	 * Add mass to the planet.
	 * 
	 * @param amt The amount of mass to add, in <unit>s.
	 */
	public void gainMass(double amt) {
		mass += amt;
	}

	/**
	 * Selects a random location in the disk to take matter from.
	 * The location, on average, is the same as the planet's
	 * location. However, the variance of the selected location
	 * increases as the planet's mass increases.
	 * 
	 * @param random A random number generator.
	 * @return The disk section's distance to the star.
	 */
	public double chooseFeedLoc(Random random) {
		// ...
		return 0.0;
	}
}
