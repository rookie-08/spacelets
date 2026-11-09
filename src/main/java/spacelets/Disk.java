package spacelets;

/**
 * @author Rookie
 */
public class Disk {
	private static final int NUM_SECTIONS = 10;
	private static final double LENGTH = 10.0;
	private static final double MASS = 100.0;

	private final double[] sections;

	public Disk() {
		// ...
		sections = null;
	}

	@Override 
	public String toString() {
		// ...
		return "";
	}

	public double loseMass(int section, double frac) {
		return 0.0;
	}

	public double loseMass(double posiiton, double frac) {
		return 0.0;
	}
}
