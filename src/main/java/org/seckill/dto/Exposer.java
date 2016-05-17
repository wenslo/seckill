package org.seckill.dto;

/**
 * ��¶��ɱ��ַDTO
 * Created by wen on 2016/5/14.
 */
public class Exposer {
    /**
     * �Ƿ�����ɱ
     */
    private boolean exposed;
    /**
     * һ�ּ��ܴ�ʩ
     */
    private String md5;
    /**
     * ID
     */
    private long seckillId;
    /**
     * ϵͳ��ǰʱ��
     */
    private long now;
    /**
     * ����ʱ��
     */
    private long start;
    /**
     * ����ʱ��
     */
    private long end;

    public Exposer(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, long now, long start, long end) {
        this.exposed = exposed;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed,long seckillId) {
        this.seckillId = seckillId;
        this.exposed = exposed;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }
}
