package spacelets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * @author Rookie
 */
public class IntegerNameGeneratorTest {
	@Test 
	public void overall() {
		IntegerNameGenerator generator = new IntegerNameGenerator(new Random());

		List<String> names = new ArrayList<>();

		for (String name : generator) {
			names.add(name);
		}

		assert names.size() > 0;
	}
}
