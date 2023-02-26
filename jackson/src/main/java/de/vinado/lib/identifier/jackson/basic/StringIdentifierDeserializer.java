package de.vinado.lib.identifier.jackson.basic;

import de.vinado.lib.identifier.IdentifierFactory;
import de.vinado.lib.identifier.basic.StringIdentifier;
import de.vinado.lib.identifier.jackson.IdentifierDeserializer;

/**
 * {@link String}-based application identifier VO.
 *
 * @param <T> the type of the {@link StringIdentifier}'s subtype if any
 * @author Vincent Nadoll
 */
public class StringIdentifierDeserializer<T extends StringIdentifier> extends IdentifierDeserializer<String, T> {

    @SuppressWarnings("unchecked")
    public StringIdentifierDeserializer() {
        super(id -> (T) new StringIdentifier(id));
    }

    protected StringIdentifierDeserializer(IdentifierFactory<String, T> factory) {
        super(factory);
    }

    @Override
    protected String deserialize(String value) {
        return value;
    }
}
