package com.zhenming.demo.spring.feature.selector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhenming
 * @date 2025/5/14 10:57
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TestSelector.class)
public @interface EnableTest {
    Class<? extends TestService> value() default TestService.class;
}
