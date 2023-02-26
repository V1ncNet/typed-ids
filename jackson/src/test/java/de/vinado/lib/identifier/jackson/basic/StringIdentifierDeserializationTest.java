package de.vinado.lib.identifier.jackson.basic;

import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.basic.StringIdentifier;
import de.vinado.lib.identifier.jackson.AbstractIdentifierDeserializationTest;

class StringIdentifierDeserializationTest extends AbstractIdentifierDeserializationTest {

    @Override
    protected String createValue() {
        return new String("foo");
    }

    @Override
    protected Class<? extends Identifier<?>> getIdentifierType() {
        return StringIdentifier.class;
    }
}
