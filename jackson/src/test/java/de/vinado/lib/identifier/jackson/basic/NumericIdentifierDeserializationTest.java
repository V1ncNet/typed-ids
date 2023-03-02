package de.vinado.lib.identifier.jackson.basic;

import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.basic.NumericIdentifier;
import de.vinado.lib.identifier.jackson.AbstractIdentifierDeserializationTest;

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
