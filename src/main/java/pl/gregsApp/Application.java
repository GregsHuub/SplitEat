package pl.gregsApp;

import io.swagger.models.Contact;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@EnableJpaRepositories
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Server API")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        Contact contact = new Contact();
        contact.setName("Grzegorz Ozimski");
        contact.setEmail("grzegorzozimski@gmail.com");
        contact.setUrl("http://github.com/");
        return new ApiInfoBuilder()
                .title("Split-Eat")
                .description("Order once and split payment with your friends!")
                .contact(String.valueOf(contact))
                .build();
    }




}
