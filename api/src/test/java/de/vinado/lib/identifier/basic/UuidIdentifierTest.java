package de.vinado.lib.identifier.basic;

import de.vinado.lib.identifier.AbstractIdentifierTest;
import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.IdentifierFactory;
import org.junit.jupiter.api.BeforeAll;

import java.util.UUID;

class UuidIdentifierTest extends AbstractIdentifierTest<UUID> {

    private static IdentifierFactory<UUID, ? extends Identifier<UUID>> factory;

    @BeforeAll
    static void beforeAll() {
        factory = UuidIdentifier::new;
    }

    @Override
    protected UUID createValueA() {
        return UUID.fromString("36119421-aacc-41ab-b206-e7c7392c73c8");
    }

    @Override
    protected UUID createValueB() {
        return UUID.fromString("061c8518-f82a-4401-946b-1ef5b414929a");
    }

    @Override
    protected Identifier<UUID> create(UUID value) {
        return factory.create(value);
    }
}
