package de.vinado.lib.identifier.jackson.basic;

import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.IdentifierFactory;
import de.vinado.lib.identifier.basic.StringIdentifier;
import de.vinado.lib.identifier.jackson.AbstractIdentifierSerializationTest;

class StringIdentifierSerializationTest extends AbstractIdentifierSerializationTest<String> {

    private static final IdentifierFactory<String, StringIdentifier> FACTORY = StringIdentifier::new;

    @Override
    protected String createValue() {
        return new String("foo");
    }

    @Override
    protected Identifier<String> create(String value) {
        return FACTORY.create(value);
    }
}
