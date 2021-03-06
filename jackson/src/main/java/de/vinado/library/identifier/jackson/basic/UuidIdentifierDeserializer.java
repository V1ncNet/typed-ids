package de.vinado.library.identifier.jackson.basic;

import de.vinado.library.identifier.IdentifierFactory;
import de.vinado.library.identifier.basic.UuidIdentifier;
import de.vinado.library.identifier.jackson.IdentifierDeserializer;

import java.util.UUID;

/**
 * {@link String}-based application identifier VO.
 *
 * @param <T> the type of the {@link UuidIdentifier}'s subtype if any
 * @author Vincent Nadoll
 */
public class UuidIdentifierDeserializer<T extends UuidIdentifier> extends IdentifierDeserializer<UUID, T> {

    @SuppressWarnings("unchecked")
    public UuidIdentifierDeserializer() {
        super(id -> (T) new UuidIdentifier(id));
    }

    protected UuidIdentifierDeserializer(IdentifierFactory<UUID, T> factory) {
        super(factory);
    }

    @Override
    protected UUID deserialize(String value) {
        return UUID.fromString(value);
    }
}
