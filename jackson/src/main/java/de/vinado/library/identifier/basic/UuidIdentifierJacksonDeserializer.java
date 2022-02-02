package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.IdentifierFactory;
import de.vinado.library.identifier.IdentifierJacksonDeserializer;

import java.util.UUID;

/**
 * {@link String}-based application identifier VO.
 *
 * @param <T> the type of the {@link UuidIdentifier}'s subtype if any
 * @author Vincent Nadoll
 */
public class UuidIdentifierJacksonDeserializer<T extends UuidIdentifier>
    extends IdentifierJacksonDeserializer<UUID, T> {

    @SuppressWarnings("unchecked")
    public UuidIdentifierJacksonDeserializer() {
        super(id -> (T) new UuidIdentifier(id));
    }

    protected UuidIdentifierJacksonDeserializer(IdentifierFactory<UUID, T> factory) {
        super(factory);
    }

    @Override
    protected UUID deserialize(String value) {
        return UUID.fromString(value);
    }
}
