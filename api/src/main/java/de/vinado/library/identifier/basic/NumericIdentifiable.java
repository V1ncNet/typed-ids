package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.Identifiable;

/**
 * Convenient typed intermediate interface for reduction of generics.
 *
 * @param <T> the type of {@link NumericIdentifier}
 * @author Vincent Nadoll
 */
public interface NumericIdentifiable<T extends NumericIdentifier> extends Identifiable<Long, T> {
}
