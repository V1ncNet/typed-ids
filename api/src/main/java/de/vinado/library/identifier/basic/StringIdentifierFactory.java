package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.IdentifierFactory;

/**
 * Typed {@link IdentifierFactory} creating a new {@link StringIdentifier} from an {@link String} value.
 *
 * @param <T> the type of the {@link StringIdentifier}'s subtype
 * @author Vincent Nadoll
 */
@FunctionalInterface
public interface StringIdentifierFactory<T extends StringIdentifier> extends IdentifierFactory<String, T> {
}
