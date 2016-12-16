package com.ezgo.config;

import com.ezgo.EzgoApplication;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * TODO: Class description here.
 *
 * @author <a href="https://github.com/quangbd1904">quangbd1904</a>
 * @name JerseyConfig.
 */
@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
    /**
     * Register JAX-RS application components.
     */
    public JerseyConfig(){
        this.packages("com.ezgo.resource", "com.ezgo.exception");
        register(EzgoApplication.class);
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
    }
}
