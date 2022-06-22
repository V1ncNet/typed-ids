package de.vinado.boot.autoconfigure.identifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.vinado.library.identifier.jackson.IdentifierModule;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Configures the {@link IdentifierModule} for Jackson (de-)serialization.
 *
 * @author Vincent Nadoll
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(ObjectMapper.class)
public class IdentifierJacksonConfiguration {

    @Bean
    public IdentifierModule identifierModule() {
        return new IdentifierModule();
    }


    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(Jackson2ObjectMapperBuilder.class)
    static class IdentifierJackson2ObjectMapperBuilderCustomizerConfiguration {

        @Bean
        IdentifierJackson2ObjectMapperBuilderCustomizer identifierJackson2ObjectMapperBuilderCustomizer(
            IdentifierModule identifierModule) {
            return new IdentifierJackson2ObjectMapperBuilderCustomizer(identifierModule);
        }


        @RequiredArgsConstructor
        static class IdentifierJackson2ObjectMapperBuilderCustomizer
            implements Jackson2ObjectMapperBuilderCustomizer, Ordered {

            private final IdentifierModule identifierModule;

            @Override
            public void customize(Jackson2ObjectMapperBuilder builder) {
                builder.modulesToInstall(identifierModule);
            }

            @Override
            public int getOrder() {
                return -1;
            }
        }
    }
}
