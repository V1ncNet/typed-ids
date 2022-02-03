package de.vinado.library.identifier.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.vinado.library.identifier.Identifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Vincent Nadoll
 */
public abstract class AbstractIdentifierSerializationTest<T> {

    private static ObjectMapper mapper;

    protected abstract T createValue();

    protected abstract Identifier<T> create(T value);

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper()
            .findAndRegisterModules();
    }

    @Test
    void serializingIdentifier_shouldSerializeValueOnly() throws JsonProcessingException {
        Identifier<T> identifier = create(createValue());
        String json = mapper.writeValueAsString(identifier);

        assertValueEquals(json);
    }

    protected void assertValueEquals(String json) {
        assertEquals("\"" + createValue() + "\"", json);
    }
}
