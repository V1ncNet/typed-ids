package de.vinado.library.identifier.uuid;

import de.vinado.library.identifier.AbstractIdentifierDeserializationTest;
import de.vinado.library.identifier.Identifier;

/**
 * @author Vincent Nadoll
 */
class UuidIdentifierDeserializationTest extends AbstractIdentifierDeserializationTest {

    @Override
    protected String createValue() {
        return new String("727e2f7b-e175-4812-bb87-876effb59d7f");
    }

    @Override
    protected Class<? extends Identifier<?>> getIdentifierType() {
        return UuidIdentifier.class;
    }
}
