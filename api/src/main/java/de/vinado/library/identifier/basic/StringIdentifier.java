package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.Identifier;

import java.util.Objects;

/**
 * {@link String}-based application identifier VO.
 *
 * @author Vincent Nadoll
 */
public class StringIdentifier extends Identifier<String> {

    private static final long serialVersionUID = -5178368424490204619L;

    public StringIdentifier(String value) {
        super(value);
    }

    @Override
    public final int compareTo(Identifier<String> that) {
        return Objects.compare(this.getValue(), that.getValue(), String::compareTo);
    }
}
