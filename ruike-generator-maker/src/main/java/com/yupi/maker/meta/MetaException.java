package com.yupi.maker.meta;

/**
 * @author: WJR
 * @create: 2025-01-02 20:08
 * @description: 元信息异常
 */
public class MetaException extends RuntimeException {

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
