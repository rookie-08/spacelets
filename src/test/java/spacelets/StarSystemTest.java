package spacelets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class StarSystemTest {
	@Test 
	public void constructor() {
		// setup
		String expected = "StarSystem [Planets(0)]";

		// invoke
		StarSystem system = new StarSystem(new Random(0l));
		String actual = system.toString();

		// analyze
		assertEquals(expected, actual);
	}
}
