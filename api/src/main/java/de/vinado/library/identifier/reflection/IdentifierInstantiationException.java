package de.vinado.library.identifier.reflection;

import java.lang.reflect.Constructor;

/**
 * Exception throw in case the instantiation of an {@link de.vinado.library.identifier.Identifier} failed.
 *
 * @author Vincent Nadoll
 */
public class IdentifierInstantiationException extends RuntimeException {

    private static final long serialVersionUID = -1204361456472885766L;

    public IdentifierInstantiationException(Constructor<?> constructor, String message, Throwable cause) {
        super("Failed to instantiate [" + constructor.getDeclaringClass().getName() + "]: " + message, cause);
    }
}
