package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.IdentifierFactory;
import de.vinado.library.identifier.IdentifierJacksonDeserializer;

/**
 * {@link String}-based application identifier VO.
 *
 * @param <T> the type of the {@link StringIdentifier}'s subtype if any
 * @author Vincent Nadoll
 */
public class StringIdentifierJacksonDeserializer<T extends StringIdentifier>
    extends IdentifierJacksonDeserializer<String, T> {

    @SuppressWarnings("unchecked")
    public StringIdentifierJacksonDeserializer() {
        super(id -> (T) new StringIdentifier(id));
    }

    protected StringIdentifierJacksonDeserializer(IdentifierFactory<String, T> factory) {
        super(factory);
    }

    @Override
    protected String deserialize(String value) {
        return value;
    }
}
