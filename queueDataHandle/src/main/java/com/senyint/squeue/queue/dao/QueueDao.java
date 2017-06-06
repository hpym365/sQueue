package com.senyint.squeue.queue.dao;

import java.util.List;
import java.util.Map;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-5 下午2:42
 */
public interface QueueDao {

    public List selectQueueByToken(Map param);

    public void insertQueue(Map param);

    public List selectQueue(Map param);

    public Map selectQueueByQueueNum(Map param);

}
