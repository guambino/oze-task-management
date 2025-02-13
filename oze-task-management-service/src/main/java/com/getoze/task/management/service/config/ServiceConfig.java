package com.getoze.task.management.service.config;

import com.getoze.task.management.repository.config.RepositoryConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfig.class})
@ComponentScan({"com.getoze.task.management.service"})
public class ServiceConfig {
}
