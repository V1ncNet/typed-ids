package de.vinado.lib.identifier.basic;

import de.vinado.lib.identifier.IdentifierFactory;

import java.util.UUID;

/**
 * Typed {@link IdentifierFactory} creating a new {@link UuidIdentifier} from an {@link UUID} value.
 *
 * @param <T> the type of the {@link UuidIdentifier}'s subtype
 * @author Vincent Nadoll
 */
@FunctionalInterface
public interface UuidIdentifierFactory<T extends UuidIdentifier> extends IdentifierFactory<UUID, T> {
}
