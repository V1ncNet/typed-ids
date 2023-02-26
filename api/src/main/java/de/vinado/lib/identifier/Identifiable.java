package de.vinado.lib.identifier;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Optional;

/**
 * Common interface to be used on any {@link Identifier}-identifiable types. E.g. domain entities.
 *
 * @param <R> the type of {@link Identifier}
 * @param <T> the type of the type {@link Identifier} encapsulates.
 * @author Vincent Nadoll
 */
@FunctionalInterface
public interface Identifiable<T, R extends Identifier<T>> {

    R getId();

    @JsonIgnore
    default Optional<T> getIdValue() {
        return Optional.ofNullable(getId())
            .map(Identifier::getValue);
    }

    static <T> T extractIdValue(Identifiable<T, ?> identifiable) {
        return Optional.ofNullable(identifiable)
            .flatMap(Identifiable::getIdValue)
            .orElse(null);
    }
}
