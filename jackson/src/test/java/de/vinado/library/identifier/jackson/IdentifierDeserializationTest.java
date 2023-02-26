package de.vinado.library.identifier.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import de.vinado.library.identifier.Identifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IdentifierDeserializationTest {

    private static ObjectMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper()
            .findAndRegisterModules();
    }

    @Test
    void deserializingRawIdentifier_shouldThrowException() {
        assertThrows(InvalidDefinitionException.class, () -> mapper.readValue("\"foo\"", Identifier.class));
    }
}
