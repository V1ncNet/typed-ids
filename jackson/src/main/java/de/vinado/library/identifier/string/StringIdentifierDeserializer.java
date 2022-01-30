package de.vinado.library.identifier.string;

import de.vinado.library.identifier.IdentifierDeserializer;
import de.vinado.library.identifier.IdentifierFactory;

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
