package com.zhenming.demo.spring.feature.handler;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author zhenming
 * @date 2025/5/8 9:22
 */
public class CustomReturnValueHandler implements HandlerMethodReturnValueHandler {

    protected final HandlerMethodReturnValueHandler handlerMethodReturnValueHandler;

    public CustomReturnValueHandler(HandlerMethodReturnValueHandler handlerMethodReturnValueHandler) {
        this.handlerMethodReturnValueHandler = handlerMethodReturnValueHandler;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ResponseBody.class)
                || returnType.hasMethodAnnotation(ResponseBody.class);
    }

    @Override
    public void handleReturnValue(@Nullable Object returnValue, @NonNull MethodParameter returnType,
                                  @NonNull ModelAndViewContainer mavContainer, @NonNull NativeWebRequest webRequest)
            throws Exception {
        //对返回的内容可以进行统一处理或管控
//        if (returnValue instanceof Result) {
//            handlerMethodReturnValueHandler.handleReturnValue(((Result) returnValue).toJSONString(),
//                    returnType, mavContainer, webRequest);
//        } else if (returnValue == null) {
//            handlerMethodReturnValueHandler.handleReturnValue(Result.ok().toJSONString(),
//                    returnType, mavContainer, webRequest);
//        } else if (returnValue.getClass().getPackage().getName().startsWith("com.zhenming")) {
//            handlerMethodReturnValueHandler.handleReturnValue(JSON.toJSONString(returnValue),
//                    returnType, mavContainer, webRequest);
//        } else {
//            handlerMethodReturnValueHandler.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
//        }
    }
}
