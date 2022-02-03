package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.Identifiable;

/**
 * Convenient typed intermediate interface for reduction of generics.
 *
 * @param <T> the type of {@link StringIdentifier}
 * @author Vincent Nadoll
 */
public interface StringIdentifiable<T extends StringIdentifier> extends Identifiable<String, T> {
}
