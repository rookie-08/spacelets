package spacelets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * @author Rookie
 */
public class DiskTest {
	public Random getTestingRandom() {
		return new Random(0l);
	}

	@Test 
	public void constructorAndToString() {
		// Setup
		String expected = "Disk [100.0, 9999999999]";

		// Invoke
		Disk disk = new Disk(getTestingRandom());
		String actual = disk.toString();

		// Analyze
		assertEquals(expected, actual);
	}

	@Test 
	public void loseMass0() {
		// Setup
		Disk disk = new Disk(getTestingRandom());
		int section = 0;
		double frac = 1.0;
		String expected = "Disk [90.0, 0999999999]";

		// Invoke
		disk.takeMass(section, frac);
		String actual = disk.toString();

		// Analyze
		assertEquals(expected, actual);
	}

	@Test 
	public void loseMass1() {
		// Setup
		Disk disk = new Disk(getTestingRandom());
		int section = 0;
		double frac = 0.5;
		String expected = "Disk [95.0, 5999999999]";

		// Invoke
		disk.takeMass(section, frac);
		String actual = disk.toString();

		// Analyze
		assertEquals(expected, actual);
	}

	@Test 
	public void loseMass2() {
		// Setup
		Disk disk = new Disk(getTestingRandom());
		int section = 5;
		double frac = 0.23;
		String expected = "Disk [97.7, 9999979999]";

		// Invoke
		disk.takeMass(section, frac);
		String actual = disk.toString();

		// Analyze
		assertEquals(expected, actual);
	}

	@Test
	public void loseMass3() {
		// Setup
		Disk disk = new Disk(getTestingRandom());
		double position = 5.32;
		double frac = 0.2;
		String expected = "Disk [98.0, 9999989999]";

		// Invoke
		disk.takeMass(position, frac);
		String actual = disk.toString();

		// Analyze
		assertEquals(expected, actual);
	}

	@Test
	public void loseMass4() {
		// Setup
		Disk disk = new Disk(getTestingRandom());
		double position = 11.32;
		double frac = -1.0;
		String expected = "Disk [100.0, 9999999999]";

		// Invoke
		disk.takeMass(position, frac);
		String actual = disk.toString();

		// Analyze
		assertEquals(expected, actual);
	}

	@Test
	public void loseMass5() {
		// Setup
		Disk disk = new Disk(getTestingRandom());
		double position = -2.3;
		double frac = 1.2;
		String expected = "Disk [90.0, 0999999999]";

		// Invoke
		disk.takeMass(position, frac);
		String actual = disk.toString();

		// Analyze
		assertEquals(expected, actual);
	}
}
