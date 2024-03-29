package de.vinado.lib.identifier.reflection;

import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.basic.StringIdentifier;
import de.vinado.lib.identifier.basic.UuidIdentifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.Serial;
import java.lang.reflect.Constructor;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InstantiationUtilsTest {

    @Test
    void instantiatingFixedValueIdentifier_shouldThrowException() throws NoSuchMethodException {
        Constructor<FixedValueIdentifier> constructor = FixedValueIdentifier.class.getDeclaredConstructor();

        assertThrows(IdentifierInstantiationException.class, () -> InstantiationUtils.instantiate(constructor, "foo"));
    }

    @Test
    void instantiatingWithIncompatibleType_shouldThrowException() throws NoSuchMethodException {
        Constructor<UuidIdentifier> constructor = UuidIdentifier.class.getDeclaredConstructor(UUID.class);

        assertThrows(IdentifierInstantiationException.class, () -> InstantiationUtils.instantiate(constructor, "foo"));
    }

    @Test
    void instantiatingConstrained_shouldThrowException() throws NoSuchMethodException {
        Constructor<ConstrainedIdentifier> constructor =
            ConstrainedIdentifier.class.getDeclaredConstructor(String.class);

        assertThrows(IdentifierInstantiationException.class, () -> InstantiationUtils.instantiate(constructor, "1"));
    }

    @Test
    void instantiatingIdentifier_shouldThrowException() throws NoSuchMethodException {
        Constructor<AbstractStringIdentifier> constructor =
            AbstractStringIdentifier.class.getDeclaredConstructor(String.class);

        assertThrows(IdentifierInstantiationException.class, () -> InstantiationUtils.instantiate(constructor, "foo"));
    }

    @Test
    void instantiatingArbitraryOneArgConstructor_shouldThrowException() throws NoSuchMethodException {
        Constructor<String> constructor = String.class.getDeclaredConstructor(String.class);

        assertThrows(IllegalArgumentException.class, () -> InstantiationUtils.instantiate(constructor, "foo"));
    }

    @ParameterizedTest
    @MethodSource("constructors")
    void instantiatingUuidIdentifier_shouldNotBeNull(Constructor<?> oneArgConstructor, Object value) {
        Identifier<?> identifier = (Identifier<?>) InstantiationUtils.instantiate(oneArgConstructor, value);

        assertNotNull(identifier);
    }

    static Arguments[] constructors() throws NoSuchMethodException {
        return new Arguments[]{
            Arguments.arguments(UuidIdentifier.class.getDeclaredConstructor(UUID.class), UUID.randomUUID()),
            Arguments.arguments(StringIdentifier.class.getDeclaredConstructor(String.class), "foo"),
        };
    }


    private abstract static class AbstractStringIdentifier extends Identifier<String> {

        @Serial
        private static final long serialVersionUID = 3110357809026800341L;

        public AbstractStringIdentifier(String value) {
            super(value);
        }
    }


    private static class ConstrainedIdentifier extends StringIdentifier {

        @Serial
        private static final long serialVersionUID = -6529056253687320049L;

        public ConstrainedIdentifier(String value) {
            super(nonNumeric(value));
        }

        private static String nonNumeric(String value) {
            try {
                Long.parseLong(value);
                throw new IllegalArgumentException();
            } catch (NumberFormatException e) {
                return value;
            }
        }
    }


    private static class FixedValueIdentifier extends StringIdentifier {

        @Serial
        private static final long serialVersionUID = -4035097647757485076L;

        public FixedValueIdentifier() {
            super("foo");
        }
    }
}
