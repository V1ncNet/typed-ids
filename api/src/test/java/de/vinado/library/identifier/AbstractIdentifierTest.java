package de.vinado.library.identifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractIdentifierTest<T> {

    private Identifier<T> a;
    private Identifier<T> b;

    protected abstract T createValueA();

    protected abstract T createValueB();

    protected abstract Identifier<T> create(T value);

    @BeforeEach
    void setUp() {
        a = create(createValueA());
        b = create(createValueB());
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

        assertEquals(a, a);
        assertEquals(a, other);
        assertNotEquals(b, other);
        assertNotEquals(a, new Object());
        assertNotEquals(a, null);
        assertNotEquals(null, a);
    }

    @Test
    void hashingId_shouldDelegateToValueHashCode() {
        T expected = createValueA();

        assertEquals(expected.hashCode(), a.hashCode());
        assertNotEquals(expected.hashCode(), b.hashCode());
    }

    @Test
    void compareTo_shouldCompareValue() {
        Identifier<T> other = create(createValueA());

        assertEquals(0, a.compareTo(other));
        assertNotEquals(0, b.compareTo(other));
    }
}
