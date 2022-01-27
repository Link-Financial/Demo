package com.link.app.demo.app.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
public class AppConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}