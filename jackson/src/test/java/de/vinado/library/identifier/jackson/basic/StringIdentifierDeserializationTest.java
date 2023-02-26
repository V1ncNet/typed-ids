package de.vinado.library.identifier.jackson.basic;

import de.vinado.library.identifier.Identifier;
import de.vinado.library.identifier.basic.StringIdentifier;
import de.vinado.library.identifier.jackson.AbstractIdentifierDeserializationTest;

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
