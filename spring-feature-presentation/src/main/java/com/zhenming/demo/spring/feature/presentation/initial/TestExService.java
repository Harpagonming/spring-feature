package com.zhenming.demo.spring.feature.presentation.initial;

import com.zhenming.demo.spring.feature.selector.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;

/**
 * @author zhenming
 * @date 2025/5/14 11:16
 */
public class TestExService extends TestService {
    private static final Logger LOG = LoggerFactory.getLogger(TestExService.class);

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("Import selector is enabled...");
        LOG.info("TestEx service has been loaded...");
    }
}
