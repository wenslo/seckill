package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by wen on 2016/5/7.
 */
public interface SeckillDao {
    /**
     * �����
     * @param seckillId
     * @param killTime
     * @return ���Ӱ������>1 ��ʾ���µļ�¼����
     */
    int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime") Date killTime);

    /**
     * ����ID��ѯ��ɱ����
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * ����ƫ������ѯ��ɱ��Ʒ�б�
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset")int offet,@Param("limit") int limit);
}
