package co.edu.tourheroapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { TourHeroApiApplication.MAIN_GROUP })
@ComponentScan(basePackages = { TourHeroApiApplication.MAIN_GROUP })
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { TourHeroApiApplication.MAIN_GROUP })

public class TourHeroApiApplication {
    public static final String MAIN_GROUP = "co.edu.tourheroapi.demo";
    public static void main(String[] args) {
        SpringApplication.run(TourHeroApiApplication.class, args);
    }

}
