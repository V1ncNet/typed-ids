package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.IdentifierFactory;
import de.vinado.library.identifier.IdentifierJacksonDeserializer;

/**
 * {@link Long}-based application identifier VO.
 *
 * @param <T> the type of the {@link NumericIdentifier}'s subtype if any
 * @author Vincent Nadoll
 */
public class NumericIdentifierJacksonDeserializer<T extends NumericIdentifier>
    extends IdentifierJacksonDeserializer<Long, T> {

    @SuppressWarnings("unchecked")
    public NumericIdentifierJacksonDeserializer() {
        super(id -> (T) new NumericIdentifier(id));
    }

    protected NumericIdentifierJacksonDeserializer(IdentifierFactory<Long, T> factory) {
        super(factory);
    }

    @Override
    protected Long deserialize(String value) {
        return Long.parseLong(value);
    }
}
