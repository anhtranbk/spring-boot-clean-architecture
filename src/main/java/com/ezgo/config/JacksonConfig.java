package com.ezgo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * TODO: Class description here.
 *
 * @author <a href="https://github.com/quangbd1904">quangbd1904</a>
 * @name JacksonConfig.
 */
@Configuration
public class JacksonConfig {

    @Autowired
    private ObjectMapper objectMapper; // reuse the pre-configured mapper

    @PostConstruct
    public void setup() {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // whatever else you need
    }

}

