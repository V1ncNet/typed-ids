package de.vinado.lib.identifier;

import de.vinado.lib.identifier.basic.StringIdentifier;
import lombok.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serial;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdentifiableTest {

    private Id id;
    private DefaultIdentifiable identifiable;

    @BeforeEach
    void setUp() {
        id = new Id("foo");
        identifiable = new DefaultIdentifiable(id);
    }

    @Test
    void extractingNullIdValue_shouldReturnNull() {
        Object value = Identifiable.extractIdValue(null);

        assertNull(value);
    }

    @Test
    void extractingIdValue_shouldMatchDefinedId() {
        String value = Identifiable.extractIdValue(identifiable);

        assertEquals(id.toString(), value);
    }

    @Test
    void retrievingIdValue_shouldMatchDefinedValue() {
        Optional<String> value = identifiable.getIdValue();

        assertTrue(value.isPresent());
        assertEquals(id.toString(), value.get());
    }

    @Test
    void retrievingNullIdValue_shouldReturnEmptyOptional() {
        identifiable = new DefaultIdentifiable(null);

        Optional<String> value = identifiable.getIdValue();

        assertFalse(value.isPresent());
    }


    @Value
    static class DefaultIdentifiable implements Identifiable<String, Id> {

        Id id;
    }


    static final class Id extends StringIdentifier {

        @Serial
        private static final long serialVersionUID = 7445742356147366291L;

        Id(String value) {
            super(value);
        }
    }
}
