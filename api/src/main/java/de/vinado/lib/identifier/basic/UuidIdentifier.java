package de.vinado.lib.identifier.basic;

import de.vinado.lib.identifier.Identifier;

import java.io.Serial;
import java.util.Objects;
import java.util.UUID;

/**
 * {@link UUID}-typed application identifier VO.
 *
 * @author Vincent Nadoll
 */
public class UuidIdentifier extends Identifier<UUID> {

    @Serial
    private static final long serialVersionUID = -6479421329720973274L;

    public UuidIdentifier(UUID value) {
        super(value);
    }

    @Override
    public final int compareTo(Identifier<UUID> other) {
        return Objects.compare(getValue(), other.getValue(), UUID::compareTo);
    }
}
