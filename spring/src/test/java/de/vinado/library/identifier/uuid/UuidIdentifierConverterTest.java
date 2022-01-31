package de.vinado.library.identifier.uuid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;

import java.util.UUID;

import static de.vinado.library.identifier.uuid.UuidIdentifierConverter.IDENTIFIER_TYPE;
import static de.vinado.library.identifier.uuid.UuidIdentifierConverter.STRING_TYPE;
import static de.vinado.library.identifier.uuid.UuidIdentifierConverter.UUID_TYPE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Vincent Nadoll
 */
class UuidIdentifierConverterTest {

    private UuidIdentifierConverter converter;

    @BeforeEach
    void setUp() {
        converter = new UuidIdentifierConverter();
    }

    @ParameterizedTest
    @MethodSource("types")
    void convertNull_shouldReturnNull(TypeDescriptor sourceType, TypeDescriptor targetType) {
        assertNull(converter.convert(null, sourceType, targetType));
    }

    @ParameterizedTest
    @MethodSource("types")
    void convertIncompatibleSource_shouldThrowException(TypeDescriptor sourceType, TypeDescriptor targetType) {
        assertThrows(ConverterNotFoundException.class, () -> converter.convert(1, sourceType, targetType));
    }

    @Test
    void convertUnknownSource_shouldThrowException() {
        assertThrows(ConverterNotFoundException.class, () -> converter.convert(UUID.randomUUID(), STRING_TYPE, IDENTIFIER_TYPE));
        assertThrows(ConverterNotFoundException.class, () -> converter.convert("foo", UUID_TYPE, IDENTIFIER_TYPE));
    }

    @Test
    void converter_shouldConvertOneWays() {
        assertTrue(converter.matches(STRING_TYPE, IDENTIFIER_TYPE));
        assertTrue(converter.matches(UUID_TYPE, IDENTIFIER_TYPE));

        assertFalse(converter.matches(IDENTIFIER_TYPE, STRING_TYPE));
        assertFalse(converter.matches(IDENTIFIER_TYPE, UUID_TYPE));
    }

    static Arguments[] types() {
        return new Arguments[]{
            arguments(STRING_TYPE, IDENTIFIER_TYPE),
            arguments(UUID_TYPE, IDENTIFIER_TYPE),
        };
    }
}
