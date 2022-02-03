package de.vinado.boot.autoconfigure.identifier;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Auto configuration for identifier VOs.
 *
 * @author Vincent Nadoll
 * @see IdentifierWebMvcConfiguration
 * @see IdentifierJacksonConfiguration
 */
@Configuration(proxyBeanMethods = false)
@Import({IdentifierWebMvcConfiguration.class, IdentifierJacksonConfiguration.class})
public class IdentifierAutoConfiguration {
}
