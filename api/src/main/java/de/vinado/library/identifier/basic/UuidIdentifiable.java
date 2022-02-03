package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.Identifiable;

import java.util.UUID;

/**
 * Convenient typed intermediate interface for reduction of generics.
 *
 * @param <T> the type of {@link UuidIdentifier}
 * @author Vincent Nadoll
 */
public interface UuidIdentifiable<T extends UuidIdentifier> extends Identifiable<UUID, T> {
}
