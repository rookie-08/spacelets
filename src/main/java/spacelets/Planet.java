package spacelets;

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
	 * Returns the posiiton of the planet in <unit>s.
	 * 
	 * @return The posiiton of the planet, in <unit>s.
	 */
	public double getPosition() {
		return position;
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
}
