package com.zhenming.demo.spring.feature.handler;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenming
 * @date 2025/5/8 9:22
 */
@Configuration
public class HandlerConfig implements InitializingBean {
    @Resource
    private RequestMappingHandlerAdapter adapter;

    @Override
    public void afterPropertiesSet() {
        List<HandlerMethodReturnValueHandler> unmodifiableList = adapter.getReturnValueHandlers();
        if (unmodifiableList == null) {
            throw new IllegalArgumentException("unmodifiableList is empty");
        }
        List<HandlerMethodReturnValueHandler> list = new ArrayList<>(unmodifiableList.size());
        for (HandlerMethodReturnValueHandler returnValueHandler : unmodifiableList) {
            if (returnValueHandler instanceof RequestResponseBodyMethodProcessor) {
                list.add(new CustomReturnValueHandler(returnValueHandler));
            } else {
                list.add(returnValueHandler);
            }
        }
        adapter.setReturnValueHandlers(list);
    }
}
