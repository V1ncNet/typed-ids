package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.Identifier;

import java.util.Objects;

/**
 * {@link Long}-base application identifier VO.
 *
 * @author Vincent Nadoll
 */
public class NumericIdentifier extends Identifier<Long> {

    private static final long serialVersionUID = 2164251350343603266L;

    public NumericIdentifier(long value) {
        super(value);
    }

    public NumericIdentifier(Long value) {
        super(value);
    }

    @Override
    public int compareTo(Identifier<Long> that) {
        return Objects.compare(this.getValue(), that.getValue(), Long::compareTo);
    }
}
