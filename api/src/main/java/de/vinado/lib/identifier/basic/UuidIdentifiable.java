package de.vinado.lib.identifier.basic;

import de.vinado.lib.identifier.Identifiable;

import java.util.UUID;

/**
 * Convenient typed intermediate interface for reduction of generics.
 *
 * @param <T> the type of {@link UuidIdentifier}
 * @author Vincent Nadoll
 */
public interface UuidIdentifiable<T extends UuidIdentifier> extends Identifiable<UUID, T> {
}
