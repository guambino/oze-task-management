package com.getoze.task.management.repository.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan(basePackages = {"com.getoze.task.management.domain.repository"})
@EnableJpaRepositories( basePackages = {"com.getoze.task.management.repository"})
public class RepositoryConfig { }
