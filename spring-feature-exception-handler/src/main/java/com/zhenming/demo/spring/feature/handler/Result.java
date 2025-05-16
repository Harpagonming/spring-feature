package com.zhenming.demo.spring.feature.handler;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author zhenming
 */
public class Result implements Serializable {
    @Serial
    private static final long serialVersionUID = 3691929808151890188L;

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success() {
        return new Result(0, "OK");
    }

    public static Result error() {
        return new Result(500, "System busy");
    }
}
