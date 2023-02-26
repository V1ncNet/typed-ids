package de.vinado.lib.identifier;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * A generic value-wrapping value object which proxies all defined methods to its encapsulated instance. The VO mainly
 * exist to enforce strictly typed identifiers in domain entities reducing the misuse of ID based query functions by
 * providing fewer options.
 *
 * @param <T> the type of the {@link Identifier}'s value
 * @author Vincent Nadoll
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Identifier<T> implements Comparable<Identifier<T>>, Serializable {

    private static final long serialVersionUID = -8801628017632098234L;

    @NonNull
    private final T value;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Identifier)) return false;
        Identifier<?> that = (Identifier<?>) obj;
        return this.value.equals(that.value);
    }

    @Override
    public final int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
