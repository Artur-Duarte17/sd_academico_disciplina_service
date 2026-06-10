package br.edu.ifgoiano.academico.sd_academico_disciplina_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do OpenAPI/Swagger.
 *
 * Após subir o serviço, a documentação interativa fica disponível em:
 *   - Swagger UI:   http://localhost:8083/swagger-ui.html
 *   - OpenAPI JSON: http://localhost:8083/v3/api-docs
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI disciplinaServiceOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Disciplina Service API")
                .description("API de cadastro e consulta de disciplinas do Sistema Acadêmico Distribuído.")
                .version("v1"));
    }
}
