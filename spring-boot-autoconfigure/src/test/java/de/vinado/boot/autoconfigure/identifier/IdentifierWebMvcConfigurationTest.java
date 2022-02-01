package de.vinado.boot.autoconfigure.identifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vincent Nadoll
 */
class IdentifierWebMvcConfigurationTest {

    private ApplicationContextRunner contextRunner;

    @BeforeEach
    void setUp() {
        contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(IdentifierWebMvcConfiguration.class);
    }

    @Test
    void configuringWithSpringWebMvc_shouldCreateIdentifierWebMvcConfiguration() {
        contextRunner
            .run(context -> assertThat(context)
                .hasSingleBean(IdentifierWebMvcConfiguration.class));
    }

    @Test
    void configuringWithoutSpringWebMvc_shouldNotCreateIdentifierWebMvcConfiguration() {
        contextRunner
            .withClassLoader(new FilteredClassLoader(WebMvcConfigurer.class))
            .run(context -> assertThat(context)
                .doesNotHaveBean(IdentifierWebMvcConfiguration.class));
    }
}
