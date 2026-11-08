package spacelets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class PlanetTest {
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
		double actual = planet.chooseFeedLoc(random);

		// Analyze
		System.out.println(actual);
	}
}
