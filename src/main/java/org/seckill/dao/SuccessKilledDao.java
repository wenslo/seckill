package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

/**
 * Created by wen on 2016/5/7.
 */
public interface SuccessKilledDao {
    /**
     * ���빺����ϸ,�ɹ����ظ�
     * @param seckillId
     * @param userPhone
     * @return ���������
     */
    int insertSuccessKilled(long seckillId,long userPhone);

    /**
     * ����ID��ѯSuccessKilled��Я����ɱ��Ʒ����ʵ��
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId,long userPhone);


}
