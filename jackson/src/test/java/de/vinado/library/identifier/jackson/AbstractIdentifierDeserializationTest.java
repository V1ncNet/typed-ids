package de.vinado.library.identifier.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.vinado.library.identifier.Identifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractIdentifierDeserializationTest {

    private static ObjectMapper mapper;

    protected abstract String createValue();

    protected abstract Class<? extends Identifier<?>> getIdentifierType();

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper()
            .findAndRegisterModules();
    }

    @Test
    void deserializingJsonValue_shouldMatchExpectedValue() throws JsonProcessingException {
        String expected = createValue();

        Identifier<?> identifier = mapper.readValue("\"" + expected + "\"", getIdentifierType());

        assertEquals(expected, identifier.toString());
    }
}
