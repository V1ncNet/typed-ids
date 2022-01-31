package de.vinado.library.identifier.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;

import java.util.UUID;

import static de.vinado.library.identifier.basic.StringIdentifierConverter.IDENTIFIER_TYPE;
import static de.vinado.library.identifier.basic.StringIdentifierConverter.STRING_TYPE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Vincent Nadoll
 */
class StringIdentifierConverterTest {

    private StringIdentifierConverter converter;

    @BeforeEach
    void setUp() {
        converter = new StringIdentifierConverter();
    }

    @Test
    void convertingNull_shouldConvertToNull() {
        assertNull(converter.convert(null, STRING_TYPE, IDENTIFIER_TYPE));
    }

    @Test
    void convertingIncompatibleSource_shouldThrowException() {
        assertThrows(ConverterNotFoundException.class, () -> converter.convert(1, STRING_TYPE, IDENTIFIER_TYPE));
    }

    @Test
    void convertingUnknownType_shouldThrowException() {
        assertThrows(ConverterNotFoundException.class, () -> converter.convert("foo", TypeDescriptor.valueOf(UUID.class), IDENTIFIER_TYPE));
    }

    @Test
    void testingTypeMatch_shouldWorkUnidirectional() {
        assertTrue(converter.matches(STRING_TYPE, IDENTIFIER_TYPE));
        assertFalse(converter.matches(IDENTIFIER_TYPE, STRING_TYPE));
    }
}
