package de.vinado.library.identifier.jackson.basic;

import de.vinado.library.identifier.Identifier;
import de.vinado.library.identifier.IdentifierFactory;
import de.vinado.library.identifier.basic.NumericIdentifier;
import de.vinado.library.identifier.jackson.AbstractIdentifierSerializationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumericIdentifierSerializationTest extends AbstractIdentifierSerializationTest<Long> {

    private static final IdentifierFactory<Long, NumericIdentifier> FACTORY = NumericIdentifier::new;

    @Override
    protected Long createValue() {
        return Long.MAX_VALUE;
    }

    @Override
    protected Identifier<Long> create(Long value) {
        return FACTORY.create(value);
    }

    @Override
    protected void assertValueEquals(String json) {
        assertEquals(Long.toString(createValue()), json);
    }
}
