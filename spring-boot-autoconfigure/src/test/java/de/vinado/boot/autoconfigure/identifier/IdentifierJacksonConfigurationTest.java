package de.vinado.boot.autoconfigure.identifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.vinado.boot.autoconfigure.identifier.IdentifierJacksonConfiguration.IdentifierJackson2ObjectMapperBuilderCustomizerConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vincent Nadoll
 */
class IdentifierJacksonConfigurationTest {

    private ApplicationContextRunner contextRunner;

    @BeforeEach
    void setUp() {
        contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(IdentifierJacksonConfiguration.class);
    }

    @Test
    void configuringWithJackson_shouldCreateIdentifierJacksonConfiguration() {
        contextRunner
            .run(context -> assertThat(context)
                .hasSingleBean(IdentifierJacksonConfiguration.class));
    }

    @Test
    void configuringWithoutJackson_shouldNotCreateIdentifierJacksonConfiguration() {
        contextRunner
            .withClassLoader(new FilteredClassLoader(ObjectMapper.class))
            .run(context -> assertThat(context)
                .doesNotHaveBean(IdentifierJacksonConfiguration.class));
    }

    @Test
    void configuringWithSpringWeb_shouldCreateObjectMapperCustomizerConfiguration() {
        contextRunner
            .run(context -> assertThat(context)
                .hasSingleBean(IdentifierJackson2ObjectMapperBuilderCustomizerConfiguration.class));
    }

    @Test
    void configuringWithoutSpringWeb_shouldNotCreateObjectMapperCustomizerConfiguration() {
        contextRunner
            .withClassLoader(new FilteredClassLoader(Jackson2ObjectMapperBuilder.class))
            .run(context -> assertThat(context)
                .doesNotHaveBean(IdentifierJackson2ObjectMapperBuilderCustomizerConfiguration.class));
    }
}
