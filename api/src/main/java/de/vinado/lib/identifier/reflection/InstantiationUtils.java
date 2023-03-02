package de.vinado.lib.identifier.reflection;

import de.vinado.lib.identifier.Identifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Utility methods for {@link Identifier}s.
 *
 * @author Vincent Nadoll
 */
public final class InstantiationUtils {

    private InstantiationUtils() {
        throw new UnsupportedOperationException("Utility class may not be instantiated");
    }

    public static <T> T instantiate(Constructor<T> constructor, Object value) throws IdentifierInstantiationException {
        assertCompatibility(constructor, "The class to be constructed must be a subtype of Identifier");

        try {
            makeAccessible(constructor);
            return constructor.newInstance(value);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            throw new IdentifierInstantiationException(constructor, "Constructor threw exception", targetException);
        } catch (InstantiationException e) {
            throw new IdentifierInstantiationException(constructor, "Is it an abstract class?", e);
        } catch (IllegalAccessException e) {
            throw new IdentifierInstantiationException(constructor, "Is the constructor accessible?", e);
        } catch (IllegalArgumentException e) {
            throw new IdentifierInstantiationException(constructor, "Illegal arguments for constructor", e);
        }
    }

    private static void assertCompatibility(Constructor<?> constructor, String message) {
        if (!Identifier.class.isAssignableFrom(constructor.getDeclaringClass())) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Make the given constructor accessible, explicitly setting it accessible if necessary. The
     * {@code setAccessible(true)} method is only called when actually necessary, to avoid unnecessary conflicts.
     *
     * @param ctor the constructor to make accessible
     * @author jhoeller
     */
    @SuppressWarnings("deprecation")
    private static void makeAccessible(Constructor<?> ctor) {
        if ((!Modifier.isPublic(ctor.getModifiers()) || !Modifier.isPublic(ctor.getDeclaringClass().getModifiers()))
            && !ctor.isAccessible()) {
            ctor.setAccessible(true);
        }
    }
}
