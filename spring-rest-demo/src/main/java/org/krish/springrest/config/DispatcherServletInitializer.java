package org.krish.springrest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; //No root-config classes for our project only servlet config class.
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{AppConfig.class};     //Our config class
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }
}
