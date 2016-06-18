package com.tbutler78.minemapping.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by butlert on 6/17/16.
 */
@SpringBootApplication
@ComponentScan("com.tbutler78.minemapping")
@EnableJpaRepositories("com.tbutler78.minemapping.repository")
@EntityScan("com.tbutler78.minemapping.domain")
public class MineMappingApplication {

  public static void main(String[] args) {
    SpringApplication.run(MineMappingApplication.class, args);

  }
}
