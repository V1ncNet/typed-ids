package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.AbstractIdentifierTest;
import de.vinado.library.identifier.Identifier;
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
