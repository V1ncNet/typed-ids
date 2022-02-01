package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.IdentifierDeserializer;
import de.vinado.library.identifier.IdentifierFactory;

/**
 * {@link Long}-based application identifier VO.
 *
 * @param <T> the type of the {@link NumericIdentifier}'s subtype if any
 * @author Vincent Nadoll
 */
public class NumericIdentifierDeserializer<T extends NumericIdentifier> extends IdentifierDeserializer<Long, T> {

    @SuppressWarnings("unchecked")
    public NumericIdentifierDeserializer() {
        super(id -> (T) new NumericIdentifier(id));
    }

    protected NumericIdentifierDeserializer(IdentifierFactory<Long, T> factory) {
        super(factory);
    }

    @Override
    protected Long deserialize(String value) {
        return Long.parseLong(value);
    }
}
