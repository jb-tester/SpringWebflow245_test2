package com.mytests.spring.webflow244.javaConfig.test2;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/21/2016.
 * Project: test2
 * *******************************
 */
public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MyWebConfig.class, MyWebflowConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/views/*"};
    }
}
