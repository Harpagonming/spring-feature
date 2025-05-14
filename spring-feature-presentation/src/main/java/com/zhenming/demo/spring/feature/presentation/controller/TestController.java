package com.zhenming.demo.spring.feature.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenming
 * @date 2025/5/14 11:51
 */
@RestController
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public ResponseEntity<String> test(int i) {
        LOG.info("test: i = {}", i);
        if (i < 100) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("{\"code\":200,\"message\":\"OK\"}");
        } else {
            throw new IllegalArgumentException("Error");
        }
    }
}
