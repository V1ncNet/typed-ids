package de.vinado.library.identifier;

/**
 * Abstract {@link FunctionalInterface function} for creation new identifiers.
 *
 * @param <T> the type of the {@link Identifier}'s value
 * @param <R> the type of the {@link Identifier} itself
 * @author Vincent Nadoll
 */
@FunctionalInterface
public interface IdentifierFactory<T, R extends Identifier<T>> {

    R create(T id);
}
