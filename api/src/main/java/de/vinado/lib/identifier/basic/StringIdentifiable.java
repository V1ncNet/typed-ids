package de.vinado.lib.identifier.basic;

import de.vinado.lib.identifier.Identifiable;

/**
 * Convenient typed intermediate interface for reduction of generics.
 *
 * @param <T> the type of {@link StringIdentifier}
 * @author Vincent Nadoll
 */
public interface StringIdentifiable<T extends StringIdentifier> extends Identifiable<String, T> {
}
