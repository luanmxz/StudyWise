package com.dev.luan.studywise.infrastructure.environment;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class DotenvEnvironmentPostProcessor
        implements EnvironmentPostProcessor, Ordered {

    private static final String DOTENV_PROPERTY_SOURCE = "dotenvProperties";

    @Override
    public void postProcessEnvironment(
            ConfigurableEnvironment environment,
            SpringApplication application) {

        // Carrega o .env a partir da raiz do projeto
        Dotenv dotenv = Dotenv.configure()
                              .filename(".env")
                              .ignoreIfMissing()
                              .load();

        Map<String, Object> map = new HashMap<>();
        dotenv.entries()
              .forEach(entry -> map.put(entry.getKey(), entry.getValue()));

        // Insere antes de qualquer outra PropertySource
        environment.getPropertySources()
                   .addFirst(new MapPropertySource(DOTENV_PROPERTY_SOURCE, map));
    }

    // Para garantir precedência máxima
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
