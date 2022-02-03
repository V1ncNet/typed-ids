package de.vinado.library.identifier.jackson.basic;

import de.vinado.library.identifier.Identifier;
import de.vinado.library.identifier.IdentifierFactory;
import de.vinado.library.identifier.basic.StringIdentifier;
import de.vinado.library.identifier.jackson.AbstractIdentifierSerializationTest;

/**
 * @author Vincent Nadoll
 */
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
