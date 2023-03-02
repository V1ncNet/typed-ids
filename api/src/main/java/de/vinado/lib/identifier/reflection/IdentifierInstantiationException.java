package de.vinado.lib.identifier.reflection;

import de.vinado.lib.identifier.Identifier;

import java.io.Serial;
import java.lang.reflect.Constructor;

/**
 * Exception throw in case the instantiation of an {@link Identifier} failed.
 *
 * @author Vincent Nadoll
 */
public class IdentifierInstantiationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1204361456472885766L;

    public IdentifierInstantiationException(Constructor<?> constructor, String message, Throwable cause) {
        super("Failed to instantiate [" + constructor.getDeclaringClass().getName() + "]: " + message, cause);
    }
}
