package de.vinado.lib.identifier.basic;

import de.vinado.lib.identifier.AbstractIdentifierTest;
import de.vinado.lib.identifier.Identifier;
import org.junit.jupiter.api.BeforeAll;

class NumericIdentifierTest extends AbstractIdentifierTest<Long> {

    private static NumericIdentifierFactory<? extends NumericIdentifier> factory;

    @BeforeAll
    static void beforeAll() {
        factory = NumericIdentifier::new;
    }

    @Override
    protected Long createValueA() {
        return Long.valueOf(42);
    }

    @Override
    protected Long createValueB() {
        return Long.valueOf(1337);
    }

    @Override
    protected Identifier<Long> create(Long value) {
        return factory.create(value);
    }
}
