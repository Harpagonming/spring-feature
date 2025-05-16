package com.zhenming.demo.spring.feature.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * {@link ResponseEntityExceptionHandler}的作用是默认处理内置Spring MVC异常。例如：
 * {@link MissingServletRequestParameterException}
 * {@link MissingServletRequestPartException}
 * {@link HttpMediaTypeNotSupportedException}等等。
 * <br>也可以不继承，从而捕获所有异常
 *
 * @author zhenming
 * @date 2025/5/8 9:21
 */
@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Result> exceptionHandler(Exception e) {
        LOG.error(e.getMessage(), e);
        //对抛错的异常统一管控，可以返回任意内容
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(Result.error());
    }

    @ExceptionHandler({MissingServletRequestParameterException.class, MissingServletRequestPartException.class})
    public ResponseEntity<Object> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        LOG.error(e.getMessage(), e);
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Object> httpMediaTypeExceptionHandler(HttpMediaTypeNotSupportedException e) {
        LOG.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> httpRequestMethodNotSupportedExceptionHandler(
            HttpRequestMethodNotSupportedException e) {
        LOG.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
}

