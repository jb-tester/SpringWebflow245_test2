package com.mytests.spring.webflow244.javaConfig.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/21/2016.
 * Project: test2
 * *******************************
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mytests.spring.webflow244.javaConfig.test2")
public class MyWebConfig extends WebMvcConfigurerAdapter {
    @Bean
    InternalResourceViewResolver resolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


}


