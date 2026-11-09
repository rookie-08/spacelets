package spacelets;

import java.util.Iterator;

/**
 * An iterable/iterator that generates unique names.
 * 
 * @author Rookie
 */
public interface NameGenerator extends Iterable<String>, Iterator<String> {
	/**
	 * If the current name is not null.
	 */
	boolean hasNext();

	/**
	 * Generates the next name before returning the current name.
	 */
	String next();

	/**
	 * Returns the NameGenerator.
	 */
	Iterator<String> iterator();
}
