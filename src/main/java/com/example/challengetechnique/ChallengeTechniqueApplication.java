package com.example.challengetechnique;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Challenge Technique APIS", version = "1.0", description = "Challenge Technique"))
public class ChallengeTechniqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeTechniqueApplication.class, args);
    }

}
