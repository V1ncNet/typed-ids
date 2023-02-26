package de.vinado.library.identifier.jackson.basic;

import de.vinado.library.identifier.Identifier;
import de.vinado.library.identifier.basic.NumericIdentifier;
import de.vinado.library.identifier.jackson.AbstractIdentifierDeserializationTest;

class NumericIdentifierDeserializationTest extends AbstractIdentifierDeserializationTest {

    @Override
    protected String createValue() {
        return String.valueOf(Long.MAX_VALUE);
    }

    @Override
    protected Class<? extends Identifier<?>> getIdentifierType() {
        return NumericIdentifier.class;
    }
}
