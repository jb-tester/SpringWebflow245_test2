package com.mytests.spring.webflow244.javaConfig.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.ViewFactoryCreator;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

import java.util.Arrays;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/21/2016.
 * Project: test2
 * *******************************
 */
@Configuration
public class MyWebflowConfig extends AbstractFlowConfiguration {

    public static final String BASE_PATH = "/WEB-INF";
    private final ExtraWebflowConfig extraWebflowConfig;

    @Autowired
    public MyWebflowConfig(@Qualifier("extraWebflowConfig") ExtraWebflowConfig extraWebflowConfig) {
        this.extraWebflowConfig = extraWebflowConfig;
    }


    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder(this.extraWebflowConfig.flowBuilderServices())
                .setParent(this.extraWebflowConfig.parentFlowRegistry())
               // .addFlowLocation("/WEB-INF/myflows/flow1.xml")
                //.addFlowLocation("/WEB-INF/myflows/flow2.xml")

                //  .addFlowLocation("/WEB-INF/myflows/flow1.xml")
                //.addFlowLocation("/WEB-INF/myflows/flow2.xml","myflow2")

               //.setBasePath("/WEB-INF/webflows/")
               //.addFlowLocationPattern("flow?/flow?.xml")

               //  .setBasePath(BASE_PATH)
               .setBasePath("/WEB-INF/")
                .addFlowLocationPattern("webflows/flow?/flow?.xml")
                .build();
    }


    @Bean
    public FlowHandlerMapping flowHandlerMapping() {
        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
        handlerMapping.setOrder(-1);
        handlerMapping.setFlowRegistry(flowRegistry());
        return handlerMapping;
    }

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry()).build();
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {
        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
        handlerAdapter.setFlowExecutor(flowExecutor());
        handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
        return handlerAdapter;
    }
}
