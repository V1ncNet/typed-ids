package de.vinado.spring.identifier.convert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;

import java.util.UUID;

import static de.vinado.spring.identifier.convert.NumericIdentifierConverter.IDENTIFIER_TYPE;
import static de.vinado.spring.identifier.convert.NumericIdentifierConverter.INTEGER_TYPE;
import static de.vinado.spring.identifier.convert.NumericIdentifierConverter.LONG_TYPE;
import static de.vinado.spring.identifier.convert.NumericIdentifierConverter.STRING_TYPE;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumericIdentifierConverterTest {

    private NumericIdentifierConverter converter;

    @BeforeEach
    void setUp() {
        converter = new NumericIdentifierConverter();
    }

    @Test
    void convertingUnknownSource_shouldThrowException() {
        assertThrows(ConverterNotFoundException.class, () -> converter.convert(1, STRING_TYPE, IDENTIFIER_TYPE));
        assertThrows(ConverterNotFoundException.class, () -> converter.convert("foo", INTEGER_TYPE, IDENTIFIER_TYPE));
    }

    @ParameterizedTest
    @MethodSource("types")
    void convertingIncompatibleSource_shouldThrowException(TypeDescriptor sourceType, TypeDescriptor targetType) {
        assertThrows(ConverterNotFoundException.class, () ->
            converter.convert(UUID.randomUUID(), sourceType, targetType));
    }

    @ParameterizedTest
    @MethodSource("types")
    void convertingNull_shouldNotConstructIdentifier(TypeDescriptor sourceType, TypeDescriptor targetType) {
        assertNull(converter.convert(null, sourceType, targetType));
    }

    @Test
    void convertingInteger_shouldConstructIdentifier() {
        converter.convert(Integer.MAX_VALUE, INTEGER_TYPE, IDENTIFIER_TYPE);
    }

    @Test
    void convertingLong_shouldConstructIdentifier() {
        converter.convert(Long.MAX_VALUE, LONG_TYPE, IDENTIFIER_TYPE);
    }

    @Test
    void convertingCompatibleString_shouldConstructIdentifier() {
        converter.convert("42", STRING_TYPE, IDENTIFIER_TYPE);
    }

    static Arguments[] types() {
        return new Arguments[]{
            arguments(STRING_TYPE, IDENTIFIER_TYPE),
            arguments(INTEGER_TYPE, IDENTIFIER_TYPE),
            arguments(LONG_TYPE, IDENTIFIER_TYPE),
        };
    }
}
