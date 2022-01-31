package de.vinado.library.identifier.basic;

import de.vinado.library.identifier.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * {@link UUID}-typed application identifier VO.
 *
 * @author Vincent Nadoll
 */
public class UuidIdentifier extends Identifier<UUID> {

    protected UuidIdentifier(UUID value) {
        super(value);
    }

    @Override
    public final int compareTo(Identifier<UUID> other) {
        return Objects.compare(getValue(), other.getValue(), UUID::compareTo);
    }
}
