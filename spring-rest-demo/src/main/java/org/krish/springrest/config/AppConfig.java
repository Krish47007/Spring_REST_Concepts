package org.krish.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc   //Similar to <mvc:annotation-driven/>
@ComponentScan(basePackages = {"org.krish.springrest"})
public class AppConfig {
/*
    //Define a bean for view-resolver
    @Bean
    public ViewResolver viewResolver()
    {
        var vr = new InternalResourceViewResolver();

        vr.setPrefix("/WEB-INF/jsp/");
        vr.setSuffix(".jsp");

        return vr;
    }*/
}
