package de.vinado.lib.identifier.basic;

import de.vinado.lib.identifier.Identifiable;

/**
 * Convenient typed intermediate interface for reduction of generics.
 *
 * @param <T> the type of {@link NumericIdentifier}
 * @author Vincent Nadoll
 */
public interface NumericIdentifiable<T extends NumericIdentifier> extends Identifiable<Long, T> {
}
