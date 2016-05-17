package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * ҵ��ӿ�:վ��"ʹ����"�Ƕ���ƽӿ�
 * ��������:������������,����,��������(return ����/�쳣)
 * Created by wen on 2016/5/14.
 */
public interface SeckillService {
    /**
     * ��ѯ���е���ɱ��¼
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * ��ѯ������ɱ��¼
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * ��ɱ����ʱ,�����ɱ�ӿڵĵ�ַ,�������ϵͳʱ�����ɱʱ��
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * ִ����ɱ����
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId,long userPhone,String md5 )
        throws SeckillException,RepeatKillException,SeckillCloseException;

}
