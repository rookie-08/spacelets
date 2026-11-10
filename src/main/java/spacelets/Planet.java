package spacelets;

import java.util.Random;

/**
 * A celestial body with a mass and distance to its parent body.
 * 
 * @author Rookie
 */
public class Planet {
	private static final double CFL_K0 = 1.0;
	private static final double INERTIA_POSITION_K1 = 1.0;
	
	/**
	 * The name of the planet.
	 */
	private final String name;

	/**
	 * The mass of this planet, in <unit>s.
	 */
	private double mass;

	/**
	 * The distance of the planet to its star, in <unit>s.
	 */
	private double position;

	/**
	 * How difficult it is to change the planet's position.
	 */
	private double orbitInertia;

	/**
	 * The amount of force applies on the planet.
	 */
	private double orbitForce;

	/**
	 * Related to the amount of force the star is applying to the planet.
	 */
	private double orbitFriction;

	/**
	 * Random number generator for methods.
	 */
	Random random;

	/**
	 * Create a planet with a set mass.
	 * 
	 * @param mass The mass to set this planet to, in <unit>s.
	 * @param position Where to place this planet. Distance from 
	 * star in <unit>s.
	 */
	public Planet(String name, double mass, double posiiton, Random random) {
		this.name = name;
		this.mass = mass;
		this.position = posiiton;
		this.random = random;
		adjustInertia();
	}

	/**
	 * Returns a String containing the planet's raw data.
	 */
	@Override 
	public String toString() {
		return "Planet [" + name + ", m=" + mass + ", x=" + position + "]";
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
	 * @return The disk section's distance to the star.
	 */
	public double chooseFeedLoc() {
		double mean = position;
		double stddev = CFL_K0 * mass;

		double x = random.nextGaussian(mean, stddev);

		return x;
	}

	/**
	 * Changes the planet's orbital inertia to better reflect its
	 * current position.
	 */
	public void adjustInertia() {
		orbitInertia = INERTIA_POSITION_K1 * mass / position;
	}

	/**
	 * Changes the planet's position to better reflect its current
	 * orbital inertia.
	 */
	public void adjustPosition() {
		position = INERTIA_POSITION_K1 * mass / orbitInertia;
	}
}
