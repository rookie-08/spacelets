package spacelets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * Test Planet.java.
 * 
 * @author Rookie
 */
public class PlanetTest {
	public static final double THRESHOLD_DEFAULT = 0.1;

	// Helper Functions
	/**
	 * Runs planet.CFL() `times` times and returns the mean and
	 * standard deviation of the results.
	 * 
	 * @param random
	 * @param planet
	 * @param times
	 * @return [mean, stddev]
	 */
	public double[] invokeCFL(Random random, Planet planet, int times) {
		// Setup
		double[] dataset = new double[times];
		double mean = 0.0;
		double stddev = 0.0;
		
		// Collect data (and create mean)
		for (int i = 0; i < times; i++) {
			double entry = planet.chooseFeedLoc(random);
			dataset[i] = entry;
			mean += entry / times;
		}

		// Create stddev
		for (int i = 0; i < times; i++) {
			stddev += (dataset[i] - mean) * (dataset[i] - mean);
		}
		stddev /= (times - 1);
		stddev = Math.sqrt(stddev);

		return new double[] {mean, stddev};
	}

	/**
	 * Returns `actual` if the error in `expected` is less than `threshold`.
	 * 
	 * @param expected
	 * @param actual
	 * @param threshold
	 * @return `actual` or `expected`
	 */
	public double calibrate(double expected, double actual, double threshold) {
		double error = (actual - expected) / expected;

		if (Math.abs(error) < threshold) {
			return expected;
		}
		return actual;
	}

	/**
	 * Returns `actual` if the error in `expected` is less than 10%.
	 * 
	 * @param expected
	 * @param actual
	 * @param threshold
	 * @return `actual` or `expected`
	 */
	public double calibrate(double expected, double actual) {
		return calibrate(expected, actual, THRESHOLD_DEFAULT);
	}

	// Test Helper Functions
	@Test 
	public void calibrate() {
		// Setup
		double calExpected = 100.0;
		double calActual = 102.0;
		double expected = 100.0;

		// Invoke
		double actual = calibrate(calExpected, calActual);

		// Analyze
		assertEquals(expected, actual);
	}

	// Test Helper Functions
	@Test 
	public void calibrate1() {
		// Setup
		double calExpected = 100.0;
		double calActual = 120.0;
		double expected = 120.0;

		// Invoke
		double actual = calibrate(calExpected, calActual);

		// Analyze
		assertEquals(expected, actual);
	}

	// Test Functions
	@Test 
	public void constructorAndToString() {
		// Setup
		double mass = 1.0;
		double position = 5.0;
		String expected = "Planet [mass=1.0, position=5.0]";

		// Invoke
		Planet planet = new Planet(mass, position);
		String actual = planet.toString();
			
		// Analyze
		assertEquals(expected, actual);
	}

	@Test
	public void gainMass() {
		// Setup
		Planet planet = new Planet(1.0, 5.0);
		double amt = 1.0;
		String expected = "Planet [mass=2.0, position=5.0]";

		// Invoke
		planet.gainMass(amt);
		String actual = planet.toString();

		// Analyze
		assertEquals(expected, actual);
	}

	@Test 
	public void chooseFeedLoc() {
		// Setup
		Random random = new Random(0l);
		Planet planet = new Planet(1.0, 5.0);

		// Invoke
		double[] actual = invokeCFL(random, planet, 100);

		// Analyze
		assertEquals(calibrate(5.0, actual[0]), 5.0);
		assertEquals(calibrate(1.0, actual[1]), 1.0);
	}
}
