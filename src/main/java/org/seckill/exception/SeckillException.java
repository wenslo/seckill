package org.seckill.exception;

/**
 * ��ɱ���ҵ���쳣
 * Created by wen on 2016/5/14.
 */
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
