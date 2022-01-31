package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.AbstractIdentifierDeserializationTest;
import de.vinado.library.identifier.Identifier;
import de.vinado.library.identifier.basic.StringIdentifier;

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
