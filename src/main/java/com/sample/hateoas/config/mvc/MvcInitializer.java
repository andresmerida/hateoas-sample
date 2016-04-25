package com.sample.hateoas.config.mvc;

import com.sample.hateoas.config.HttpSessionConfig;
import com.sample.hateoas.config.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by andresmerida on 4/4/2016.
 */

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // tag::config[]
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SecurityConfig.class, HttpSessionConfig.class};
    }
    // end::config[]

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
