package riwi.Biblioteca.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Biblioteca", version = "1.0", description = "Documentación api de una biblioteca"))
public class Swagger {
}
