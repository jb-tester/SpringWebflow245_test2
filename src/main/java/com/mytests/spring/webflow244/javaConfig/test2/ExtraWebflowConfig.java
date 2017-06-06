package com.mytests.spring.webflow244.javaConfig.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.ViewFactoryCreator;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

import java.util.Arrays;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/5/2017.
 * Project: test2
 * *******************************
 */
@Configuration
public class ExtraWebflowConfig extends AbstractFlowConfiguration {

    final
    MyWebConfig myWebConfig;

    @Autowired
    public ExtraWebflowConfig(MyWebConfig myWebConfig) {
        this.myWebConfig = myWebConfig;
    }

    @Bean
    public FlowDefinitionRegistry parentFlowRegistry() {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
                .addFlowLocation("/WEB-INF/extraflows/extra.xml", "extra")
                .build();

    }
    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder().
                setViewFactoryCreator(viewFactoryCreator())
                .build();
    }
    @Bean
    public ViewFactoryCreator viewFactoryCreator() {
        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(Arrays.<ViewResolver>asList(this.myWebConfig.resolver()));
        factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }
}
