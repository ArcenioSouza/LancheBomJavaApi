package br.com.lanchebom;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                title = "LancheBom_API",
                description = "Api de gerenciamento de pedidos de uma lanchone",
                version = "1",
                contact = @Contact(name = "Arcenio Souza", email = "arcenio_neto@icloud.com")
        ),
        servers = @Server(
                url = "http://localhost:5000",
                description = "Aprendendo a criar api com Java e Spring Boot"
        )
)

@SpringBootApplication
public class LancheBomJavaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LancheBomJavaApiApplication.class, args);
    }

}
