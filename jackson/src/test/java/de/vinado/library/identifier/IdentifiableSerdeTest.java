package de.vinado.library.identifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.vinado.library.identifier.basic.StringIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Vincent Nadoll
 */
class IdentifiableSerdeTest {

    private static ObjectMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper()
            .findAndRegisterModules();
    }

    @Test
    void serializingIdentifiable_shouldContainIdentifierAsId() throws JsonProcessingException {
        Identifiable.Id identifier = new Identifiable.Id("foo");
        Identifiable identifiable = new Identifiable(identifier);

        String json = mapper.writeValueAsString(identifiable);

        assertEquals("{\"id\":\"foo\"}", json);
    }

    @Test
    void deserializingIdentifiable_shouldMapIdFieldToIdentifier() throws JsonProcessingException {
        Identifiable identifiable = mapper.readValue("{\"id\":\"foo\"}", Identifiable.class);

        assertEquals("foo", identifiable.getId().toString());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Identifiable {

        private Id id;

        private static final class Id extends StringIdentifier {

            Id(String value) {
                super(value);
            }
        }
    }
}
