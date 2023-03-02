package de.vinado.lib.identifier.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.IdentifierFactory;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * Abstract {@link JsonDeserializer} that reads a value from the JSON tree and converts it into a subtype of
 * {@link Identifier}.
 *
 * @param <T> the type of the {@link Identifier}'s value
 * @param <R> the type of the {@link Identifier} itself
 * @author Vincent Nadoll
 */
@RequiredArgsConstructor
public abstract class IdentifierDeserializer<T, R extends Identifier<T>> extends JsonDeserializer<R> {

    private final IdentifierFactory<T, R> factory;

    @Override
    public R deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String value = node.asText();
        T idValue = deserialize(value);
        return factory.create(idValue);
    }

    protected abstract T deserialize(String value);
}
