package org.seckill.exception;

/**
 * ��ɱ�ر��쳣
 * Created by wen on 2016/5/14.
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
