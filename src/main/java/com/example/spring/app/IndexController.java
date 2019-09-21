package com.example.spring.app;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public Map<String, Object> index() {
        return ImmutableMap.<String, Object>builder()
                .put("datetime", System.currentTimeMillis())
                .put("number_cores", Runtime.getRuntime().availableProcessors())
                .put("routing_engine", "Spring dispatcherServlet")
                .put("server", "Tomcat")
                .build();
    }
}
