package spacelets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class StarSystemTest {
	@Test 
	public void constructor() {
		// setup
		String expected = "StarSystem\nDisk [100.0, 9999999999]\nPlanets (0):\n";

		// invoke
		Random random = new Random(0l);
		StarSystem system = new StarSystem(random, new IntegerNameGenerator(random));
		String actual = system.toString();

		// analyze
		assertEquals(expected, actual);
	}
}
