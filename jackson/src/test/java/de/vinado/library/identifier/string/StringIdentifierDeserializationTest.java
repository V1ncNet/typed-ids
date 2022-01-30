package de.vinado.library.identifier.string;

import de.vinado.library.identifier.AbstractIdentifierDeserializationTest;
import de.vinado.library.identifier.Identifier;

/**
 * @author Vincent Nadoll
 */
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
