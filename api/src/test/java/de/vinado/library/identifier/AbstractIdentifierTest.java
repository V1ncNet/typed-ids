package de.vinado.library.identifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractIdentifierTest<T> {

    private Identifier<T> identifier0;
    private Identifier<T> identifier1;

    protected abstract T createValueA();

    protected abstract T createValueB();

    protected abstract Identifier<T> create(T value);

    @BeforeEach
    void setUp() {
        identifier0 = create(createValueA());
        identifier1 = create(createValueB());
    }

    @Test
    void initializeNullArguments_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> create(null));
    }

    @Test
    void stringifyValue_shouldDelegateToStringMethod() {
        T expected = createValueA();

        Identifier<T> actual = create(expected);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testingEquality_shouldCompareValues() {
        Identifier<T> other = create(createValueA());

        assertEquals(identifier0, identifier0);
        assertEquals(identifier0, other);
        assertNotEquals(identifier1, other);
        assertNotEquals(identifier0, new Object());
        assertNotEquals(identifier0, null);
        assertNotEquals(null, identifier0);
    }

    @Test
    void hashingId_shouldDelegateToValueHashCode() {
        T expected = createValueA();

        assertEquals(expected.hashCode(), identifier0.hashCode());
        assertNotEquals(expected.hashCode(), identifier1.hashCode());
    }

    @Test
    void compareTo_shouldCompareValue() {
        Identifier<T> other = create(createValueA());

        assertEquals(0, identifier0.compareTo(other));
        assertNotEquals(0, identifier1.compareTo(other));
    }
}
