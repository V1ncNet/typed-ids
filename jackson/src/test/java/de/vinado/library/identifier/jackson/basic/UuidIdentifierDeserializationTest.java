package de.vinado.library.identifier.jackson.basic;

import de.vinado.library.identifier.Identifier;
import de.vinado.library.identifier.basic.UuidIdentifier;
import de.vinado.library.identifier.jackson.AbstractIdentifierDeserializationTest;

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
