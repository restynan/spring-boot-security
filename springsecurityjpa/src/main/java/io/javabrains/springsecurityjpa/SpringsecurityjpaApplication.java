package io.javabrains.springsecurityjpa;

import io.javabrains.springsecurityjpa.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
//@ComponentScan({"io.javabrains.springsecurityjpa.service","io.javabrains.springsecurityjpa.securityConfig","io.javabrains.springsecurityjpa.repository", "io.javabrains.springsecurityjpa.domain"})
public class SpringsecurityjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityjpaApplication.class, args);
    }

}
