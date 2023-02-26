package de.vinado.library.identifier.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.vinado.library.identifier.basic.StringIdentifiable;
import de.vinado.library.identifier.basic.StringIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdentifiableSerdeTest {

    private static ObjectMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper()
            .findAndRegisterModules();
    }

    @Test
    void serializingIdentifiable_shouldContainIdentifierAsId() throws JsonProcessingException {
        DefaultIdentifiable.Id identifier = new DefaultIdentifiable.Id("foo");
        DefaultIdentifiable identifiable = new DefaultIdentifiable(identifier);

        String json = mapper.writeValueAsString(identifiable);

        assertEquals("{\"id\":\"foo\"}", json);
    }

    @Test
    void deserializingIdentifiable_shouldMapIdFieldToIdentifier() throws JsonProcessingException {
        DefaultIdentifiable identifiable = mapper.readValue("{\"id\":\"foo\"}", DefaultIdentifiable.class);

        assertEquals("foo", identifiable.getId().toString());
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class DefaultIdentifiable implements StringIdentifiable<DefaultIdentifiable.Id> {

        private Id id;

        private static final class Id extends StringIdentifier {

            private static final long serialVersionUID = 8853764053141656003L;

            Id(String value) {
                super(value);
            }
        }
    }
}
