package com.example.bot;

import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class KitchenSinkWebMvcConfigurer implements WebMvcConfigurer {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(KitchenSinkWebMvcConfigurer.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String downloadedContentUri = KitchenSinkApplication.downloadedContentDir
                .toUri().toASCIIString();
        log.info("downloaded dir: {}", downloadedContentUri);
        registry.addResourceHandler("/downloaded/**")
                .addResourceLocations(downloadedContentUri);
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
