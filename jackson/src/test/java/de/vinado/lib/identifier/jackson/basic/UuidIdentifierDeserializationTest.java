package de.vinado.lib.identifier.jackson.basic;

import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.basic.UuidIdentifier;
import de.vinado.lib.identifier.jackson.AbstractIdentifierDeserializationTest;

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
