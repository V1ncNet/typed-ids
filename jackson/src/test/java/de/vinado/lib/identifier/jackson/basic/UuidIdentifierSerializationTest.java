package de.vinado.lib.identifier.jackson.basic;

import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.IdentifierFactory;
import de.vinado.lib.identifier.basic.UuidIdentifier;
import de.vinado.lib.identifier.jackson.AbstractIdentifierSerializationTest;

import java.util.UUID;

class UuidIdentifierSerializationTest extends AbstractIdentifierSerializationTest<UUID> {

    private static final IdentifierFactory<UUID, UuidIdentifier> FACTORY = UuidIdentifier::new;

    @Override
    protected UUID createValue() {
        return UUID.fromString("e96c84bb-49ab-4eb5-b197-c0feec236726");
    }

    @Override
    protected Identifier<UUID> create(UUID value) {
        return FACTORY.create(value);
    }
}
