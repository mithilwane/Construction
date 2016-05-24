package com.responsyve.repositories;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.responsyve.domain"})
@EnableJpaRepositories(basePackages = {"com.responsyve.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}