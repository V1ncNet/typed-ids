package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.AbstractIdentifierDeserializationTest;
import de.vinado.library.identifier.Identifier;

/**
 * @author Vincent Nadoll
 */
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
