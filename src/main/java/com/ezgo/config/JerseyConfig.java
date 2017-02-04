package com.ezgo.config;

import com.ezgo.BookApplication;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

//@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
    /**
     * Register JAX-RS application components.
     */
    public JerseyConfig(){
        this.packages("com.ezgo.resource", "com.ezgo.exception");
        register(BookApplication.class);
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
    }
}
