package de.vinado.boot.autoconfigure.identifier;

import de.vinado.spring.identifier.convert.NumericIdentifierConverter;
import de.vinado.spring.identifier.convert.StringIdentifierConverter;
import de.vinado.spring.identifier.convert.UuidIdentifierConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configures the identifier {@link org.springframework.core.convert.converter.Converter}s for Spring WebMVC.
 *
 * @author Vincent Nadoll
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(WebMvcConfigurer.class)
public class IdentifierWebMvcConfiguration {

    @Bean
    IdentifierWebMvcConfigurer identifierWebMvcConfigurer() {
        return new IdentifierWebMvcConfigurer();
    }


    static class IdentifierWebMvcConfigurer implements WebMvcConfigurer {

        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new NumericIdentifierConverter());
            registry.addConverter(new StringIdentifierConverter());
            registry.addConverter(new UuidIdentifierConverter());
        }
    }
}
