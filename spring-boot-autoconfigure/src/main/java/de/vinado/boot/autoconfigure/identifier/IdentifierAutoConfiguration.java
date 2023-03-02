package de.vinado.boot.autoconfigure.identifier;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Auto configuration for identifier VOs.
 *
 * @author Vincent Nadoll
 * @see IdentifierWebMvcConfiguration
 * @see IdentifierJacksonConfiguration
 */
@AutoConfiguration
@Import({IdentifierWebMvcConfiguration.class, IdentifierJacksonConfiguration.class})
public class IdentifierAutoConfiguration {
}
