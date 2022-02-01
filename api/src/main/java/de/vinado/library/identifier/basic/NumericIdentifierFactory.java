package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.IdentifierFactory;

/**
 * Typed {@link IdentifierFactory} creating a new {@link NumericIdentifier} from an {@link Long} value.
 *
 * @param <T> the type of the {@link NumericIdentifier}'s subtype
 * @author Vincent Nadoll
 */
@FunctionalInterface
public interface NumericIdentifierFactory<T extends NumericIdentifier> extends IdentifierFactory<Long, T> {
}
