package org.seckill.exception;

/**
 * �ظ���ɱ�쳣(RuntimeException)
 * Created by wen on 2016/5/14.
 */
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
