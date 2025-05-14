package com.zhenming.demo.spring.feature.presentation;

import com.zhenming.demo.spring.feature.presentation.initial.TestExService;
import com.zhenming.demo.spring.feature.selector.EnableTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhenming
 * @date 2025/5/14 10:08
 */
@EnableTest(TestExService.class)
@SpringBootApplication
public class PresentationApplication {
    private static final Logger LOG = LoggerFactory.getLogger(PresentationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PresentationApplication.class, args);
        LOG.info("Presentation Application started...");
    }
}
