package com.project.adoption.pet;

import com.project.adoption.pet.config.SharedDatabaseConfig;
import com.project.adoption.pet.util.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients()
@ImportAutoConfiguration(FeignAutoConfiguration.class)
@EntityScan(basePackages = Constants.ENTITY_PACKAGE)
@EnableJpaRepositories(basePackages = Constants.REPOSITORY_PACKAGE)
@Import(SharedDatabaseConfig.class)
public class PetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetApplication.class, args);
    }

}
