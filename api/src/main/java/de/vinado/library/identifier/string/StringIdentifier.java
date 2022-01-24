package de.vinado.library.identifier.string;

import de.vinado.library.identifier.Identifier;

/**
 * {@link String}-based application identifier VO.
 *
 * @author Vincent Nadoll
 */
public class StringIdentifier extends Identifier<String> {

    protected StringIdentifier(String value) {
        super(value);
    }
}
