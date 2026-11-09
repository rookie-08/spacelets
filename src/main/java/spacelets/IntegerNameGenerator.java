package spacelets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author Rookie
 */
public class IntegerNameGenerator implements NameGenerator {
	private String currentName;
	private Set<String> usedNames;
	private Random random;
	
	public IntegerNameGenerator(Random random) {
		usedNames = new HashSet<>();
		this.random = random;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		return null;
	}

	@Override
	public String next() {
		return null;
	}
}
