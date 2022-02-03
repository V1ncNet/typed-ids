package de.vinado.library.identifier.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.vinado.library.identifier.Identifier;

import java.io.IOException;

/**
 * Jackson {@link JsonSerializer} for converting {@link Identifier} instances into a JSON string.
 *
 * @author Vincent Nadoll
 */
@SuppressWarnings("rawtypes")
public class IdentifierSerializer extends JsonSerializer<Identifier> {

    @Override
    public void serialize(Identifier identifier, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (null == identifier) {
            gen.writeNull();
        } else {
            provider.defaultSerializeValue(identifier.getValue(), gen);
        }
    }
}
