package spacelets;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * @author Rookie
 */
public class IntegerNameGeneratorTest {
	@Test 
	public void overall() {
		IntegerNameGenerator generator = new IntegerNameGenerator(new Random());

		assert generator != null;
	}
}
