package com.walletmanagement;

import java.util.stream.Stream;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.support.DatabaseStartupValidator;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class WalletManagementApplication {

  public static void main(String[] args) {
    SpringApplication.run(WalletManagementApplication.class, args);
  }

  @Bean
  public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
    resourceBundleMessageSource.setBasename("messages/messages");
    resourceBundleMessageSource.setDefaultEncoding("ISO-8859-1");
    resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
    return resourceBundleMessageSource;
  }

  @Bean
  public static BeanFactoryPostProcessor dependsOnPostProcessor() {
    return bf -> {
      String[] flyway = bf.getBeanNamesForType(Flyway.class);

      Stream.of(flyway)
          .map(bf::getBeanDefinition)
          .forEach(it -> it.setDependsOn("databaseStartupValidator"));

      String[] jpa = bf.getBeanNamesForType(EntityManagerFactory.class);

      Stream.of(jpa)
          .map(bf::getBeanDefinition)
          .forEach(it -> it.setDependsOn("databaseStartupValidator"));
    };
  }

  @Bean
  public DatabaseStartupValidator databaseStartupValidator(DataSource dataSource) {
    DatabaseStartupValidator dsv = new DatabaseStartupValidator();

    dsv.setDataSource(dataSource);
    dsv.setTimeout(120);
    dsv.setInterval(7);
    dsv.afterPropertiesSet();
    
    return dsv;
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {

      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "PATCH", "OPTIONS", "DELETE")
            .allowedHeaders("Authorization", "x-xsrf-token", "Access-Control-Allow-Headers", "Origin",
                "Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Auth-Id-Token");
      }

    };
  }

}
