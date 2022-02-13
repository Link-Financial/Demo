package com.steven.testnavin.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.steven.testnavin.repository")
public class PersistenceConfig {
}
