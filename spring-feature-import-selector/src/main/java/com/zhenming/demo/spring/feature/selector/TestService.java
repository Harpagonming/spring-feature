package com.zhenming.demo.spring.feature.selector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhenming
 * @date 2025/5/14 10:36
 */
@Component
public class TestService implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(TestService.class);

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("Import selector is enabled...");
        LOG.info("Test service has been loaded...");
    }
}