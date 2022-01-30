package de.vinado.library.identifier.string;

import de.vinado.library.identifier.AbstractIdentifierTest;
import de.vinado.library.identifier.Identifier;
import de.vinado.library.identifier.IdentifierFactory;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author Vincent Nadoll
 */
class StringIdentifierTest extends AbstractIdentifierTest<String> {

    private static IdentifierFactory<String, ? extends Identifier<String>> factory;

    @BeforeAll
    static void beforeAll() {
        factory = StringIdentifier::new;
    }

    @Override
    protected String createValueA() {
        return new String("foo");
    }

    @Override
    protected String createValueB() {
        return new String("bar");
    }

    @Override
    protected Identifier<String> create(String value) {
        return factory.create(value);
    }
}
