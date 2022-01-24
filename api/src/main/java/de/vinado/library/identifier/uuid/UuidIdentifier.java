package de.vinado.library.identifier.uuid;

import de.vinado.library.identifier.Identifier;

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
}
