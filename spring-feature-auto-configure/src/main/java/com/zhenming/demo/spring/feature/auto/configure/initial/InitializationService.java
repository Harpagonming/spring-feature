package com.zhenming.demo.spring.feature.auto.configure.initial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhenming
 * @date 2025/5/14 10:20
 */
@Component
public class InitializationService implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(InitializationService.class);

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("Initialization service has been loaded...");
    }
}
