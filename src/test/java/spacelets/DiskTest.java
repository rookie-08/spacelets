package spacelets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Rookie
 */
public class DiskTest {
	@Test 
	public void constructorAndToString() {
		// Setup
		String expected = "Disk [100.0, 9999999999]";

		// Invoke
		Disk disk = new Disk();
		String actual = disk.toString();

		// Analyze
		assertEquals(expected, actual);
	}
}
